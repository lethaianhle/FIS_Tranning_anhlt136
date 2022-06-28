package com.fis.app.service;

import com.fis.app.dto.CustomerDTO;
import com.fis.app.dto.CustomerPaginationDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    CustomerPaginationDTO findAll(int page, int size);

    CustomerDTO findById(Long id);

    List<CustomerDTO> create(CustomerDTO customerDTO);

    CustomerDTO update(Long id, CustomerDTO customerDTO);

    void delete(Long id);

}
