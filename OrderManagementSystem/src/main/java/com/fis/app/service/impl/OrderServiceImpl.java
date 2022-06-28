package com.fis.app.service.impl;

import com.fis.app.dto.OrderDTO;
import com.fis.app.dto.OrderItemDTO;
import com.fis.app.dto.OrderPaginationDTO;
import com.fis.app.dto.OrderRequestDTO;
import com.fis.app.entity.Customer;
import com.fis.app.entity.Order;
import com.fis.app.entity.OrderItem;
import com.fis.app.entity.Product;
import com.fis.app.enums.OrderStatus;
import com.fis.app.exception.*;
import com.fis.app.repo.CustomerRepo;
import com.fis.app.repo.OrderItemRepo;
import com.fis.app.repo.OrderRepo;
import com.fis.app.repo.ProductRepo;
import com.fis.app.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    OrderRepo orderRepo;

    ModelMapper modelMapper;

    ProductRepo productRepo;

    OrderItemRepo orderItemRepo;

    CustomerRepo customerRepo;

    public OrderServiceImpl(OrderRepo orderRepo,
                            ModelMapper modelMapper,
                            ProductRepo productRepo,
                            OrderItemRepo orderItemRepo,
                            CustomerRepo customerRepo) {
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;
        this.productRepo = productRepo;
        this.orderItemRepo = orderItemRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderRepo.findAll().stream()
                .map(order -> modelMapper.map(order,  OrderDTO.class))
                .toList();
    }

    @Override
    public OrderPaginationDTO findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orderPage = orderRepo.findAll(pageable);

        if (page > orderPage.getTotalPages()) throw new ParamInvalidException("Lỗi số page không hợp lệ!");

        OrderPaginationDTO orderPaginationDTO = new OrderPaginationDTO();
        orderPaginationDTO.setTotalPage(orderPage.getTotalPages());
        orderPaginationDTO.setPageNumber(orderPage.getNumber());
        orderPaginationDTO.setNumberOfElements(orderPage.getNumberOfElements());

        List<OrderDTO> dtos = orderPage.getContent().stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .toList();

        orderPaginationDTO.setOrders(dtos);

        return orderPaginationDTO;
    }

    @Override
    public OrderDTO created(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDateTime(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);

        Customer customer = customerRepo.findById(orderDTO.getCustomerId())
                                        .orElseThrow(() -> new CustomerNotFoundException("Thêm mới Order thất bại - không tìm thấy customer với id: " + orderDTO.getCustomerId()));
        order.setCustomer(customer);

        // Xử lý với mỗi product trong đơn hàng sẽ:
        List<OrderItem> orderItems = new ArrayList<>();
        AtomicReference<Double> totalAmount = new AtomicReference<>(0.0);
        orderDTO.getOrderItems().forEach(orderItemDTO -> {
            OrderItem orderItem = new OrderItem();
            Product product = productRepo.findById(orderItemDTO.getProductId())
                                         .orElseThrow(() -> new ProductNotFoundException("Thêm mới Order thất bại - không tìm thấy product với id: " + orderItemDTO.getProductId()));

            if (product.getAvailable() < orderItemDTO.getQuantity() || product.getAvailable() <= 0) {
                throw new ProductQuantityNotEnoughException("Số lượng hàng với id " + product.getId() + " <= 0!");
            }
            product.setAvailable(product.getAvailable() - orderItemDTO.getQuantity()); // cập nhập lại giá trị available

            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setOrder(order);
            orderItem.setAmount(orderItemDTO.getQuantity() * product.getPrice()); // tự động tính giá trị tổng của mặt hàng
            totalAmount.updateAndGet(v -> v + orderItem.getAmount()); // tự động tính tổng đơn hàng

            OrderItem orderItemCreated = orderItemRepo.save(orderItem); // ??
            orderItems.add(orderItemCreated);
        });

        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount.get());

        orderRepo.save(order);
        log.info("Order -> {}", order);
        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Không tìm thấy Order với id: " + id));

        if (order.getStatus() == OrderStatus.CREATED || order.getStatus() == OrderStatus.CANCELLED)
            orderRepo.deleteById(id);
        else
            throw new OrderStatusInvalidException("Xóa Order thất bại - Order trạng thái không thể xóa!");
    }

    @Override
    public OrderDTO cancelOrder(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Không tìm thấy order với id: " + id));

        if (order.getStatus() != OrderStatus.CREATED)
            throw new OrderStatusInvalidException("Hủy Order thất bại - Order trạng thái không thể hủy!");

        order.setStatus(OrderStatus.CANCELLED);
        Order updatedOrder = orderRepo.save(order);

        return modelMapper.map(updatedOrder, OrderDTO.class);
    }

    @Override
    public OrderDTO paidOrder(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Không tìm thấy order với id: " + id));

        if (order.getStatus() != OrderStatus.CREATED)
            throw new OrderStatusInvalidException("Paid Order thất bại - Order trạng thái không thể paid!");

        order.setStatus(OrderStatus.PAID);
        Order updatedOrder = orderRepo.save(order);

        return modelMapper.map(updatedOrder, OrderDTO.class);
    }

    @Override
    public OrderDTO addOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();

        Order order = orderRepo.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Không tìm thấy order với id: " + orderItemDTO.getOrderId()));

        if (order.getStatus() != OrderStatus.CREATED)
            throw new OrderStatusInvalidException("Thêm mới OrderItem thất bại - Trạng thái order không hợp lệ!");

        Product product = productRepo.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Thêm mới OrderItem thất bại - không tìm thấy product với id: "
                                + orderItemDTO.getProductId()));

        if (product.getAvailable() < orderItemDTO.getQuantity() || product.getAvailable() <= 0) {
            throw new ProductQuantityNotEnoughException("Thêm mới OrderItem thất bại - Số lượng hàng với id " + product.getId() + " <= 0!");
        }
        product.setAvailable(product.getAvailable() - orderItemDTO.getQuantity()); // cập nhập lại giá trị available

        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setAmount(product.getPrice() * orderItemDTO.getQuantity()); // tính lại amount
        OrderItem orderItemSaved = orderItemRepo.save(orderItem); // save orderItem

        order.getOrderItems().add(orderItemSaved);
        order.setTotalAmount(order.getTotalAmount() + orderItemSaved.getAmount()); // tính lại totalAmount
        Order orderSaved = orderRepo.save(order);   // save Order
        return modelMapper.map(orderSaved, OrderDTO.class);
    }

    @Override
    public OrderDTO removeOrderItem(OrderRequestDTO orderRequestDTO) {
        Order order = orderRepo.findById(orderRequestDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Không tìm thấy order với id: " + orderRequestDTO.getOrderId()));

        if (order.getStatus() != OrderStatus.CREATED)
            throw new OrderStatusInvalidException("Xóa OrderItem thất bại - Trạng thái order không hợp lệ!");

        OrderItem orderItem = orderItemRepo.findById(orderRequestDTO.getOrderItemId())
                .orElseThrow(() -> new OrderItemNotFoundException("Xóa OrderItem thất bại - Không tìm thấy orderItem id: "
                        + orderRequestDTO.getOrderItemId()));

        orderItemRepo.deleteById(orderItem.getId());
        order.getOrderItems().remove(orderItem);
        Order orderSaved = orderRepo.save(order);

        return modelMapper.map(order, OrderDTO.class);
    }

}
