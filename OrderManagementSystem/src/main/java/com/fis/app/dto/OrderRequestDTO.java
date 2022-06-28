package com.fis.app.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderRequestDTO {

    @NotNull
    private Long orderId;

    @NotNull
    private Long orderItemId;

}
