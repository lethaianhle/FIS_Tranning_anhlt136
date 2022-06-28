package com.fis.app.dto;

import com.fis.app.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderPaginationDTO {

    private List<OrderDTO> orders;

    Integer totalPage;

    Integer pageNumber;

    Integer numberOfElements;

}
