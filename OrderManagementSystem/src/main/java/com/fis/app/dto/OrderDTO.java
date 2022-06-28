package com.fis.app.dto;

import com.fis.app.entity.Customer;
import com.fis.app.entity.OrderItem;
import com.fis.app.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private LocalDateTime orderDateTime;

    private Long customerId;

    private List<OrderItemDTO> orderItems;

    private Double totalAmount;

    private OrderStatus status;

}
