package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order addOrderItem(Long orderId,OrderItem orderItem) {
        return null;
    }

    @Override
    public Order removeOrderItem(Long orderId,OrderItem orderItem) {
        return null;
    }

    @Override
    public Order updateOrderStatus(Order order,OrderStatus orderStatus) {
        return null;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return null;
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {
        return null;
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return Collections.emptyList();
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        return Collections.emptyList();
    }
}
