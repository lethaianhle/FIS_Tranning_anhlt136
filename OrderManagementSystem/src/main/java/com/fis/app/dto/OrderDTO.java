package com.fis.app.dto;

import com.fis.app.enums.OrderStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private LocalDateTime orderDateTime;

    @NotNull
    private Long customerId;

    private List<OrderItemDTO> orderItems;

    private Double totalAmount;

    @NotNull
    private OrderStatus status;

}
