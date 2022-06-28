package com.fis.app.service;

import com.fis.app.dto.OrderDTO;
import com.fis.app.dto.OrderItemDTO;
import com.fis.app.dto.OrderPaginationDTO;
import com.fis.app.dto.OrderRequestDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAll();

    OrderPaginationDTO findAll(int page, int size);

    OrderDTO created(OrderDTO orderDTO);

    void delete(Long id);

    OrderDTO cancelOrder(Long id);

    OrderDTO paidOrder(Long id);

    OrderDTO addOrderItem(OrderItemDTO orderItemDTO);

    OrderDTO removeOrderItem(OrderRequestDTO orderRequestDTO);

}
