package com.fis.app.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemDTO {

    private Long id;

    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    private Long quantity;

    private Double amount;

}
