package com.fis.app.dto;

import com.fis.app.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPaginationDTO {

    private List<Customer> customerList;

    Integer totalPage;

    Integer pageNumber;

    Integer numberOfElements;

}
