package com.fis.app.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;

    private Long orderId;

    private Long productId;

    private Long quantity;

    private Double amount;

}
