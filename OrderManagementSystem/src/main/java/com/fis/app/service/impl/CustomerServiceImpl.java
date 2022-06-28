package com.fis.app.service.impl;

import com.fis.app.dto.CustomerDTO;
import com.fis.app.dto.CustomerPaginationDTO;
import com.fis.app.entity.Customer;
import com.fis.app.exception.CustomerNotFoundException;
import com.fis.app.exception.ParamInvalidException;
import com.fis.app.repo.CustomerRepo;
import com.fis.app.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepo customerRepo;

    ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepo.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerPaginationDTO findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage = customerRepo.findAll(pageable);

        if (page > customerPage.getTotalPages()) throw new ParamInvalidException("Lỗi số page không hợp lệ!");

        CustomerPaginationDTO customerPaginationDTO = new CustomerPaginationDTO();
        customerPaginationDTO.setTotalPage(customerPage.getTotalPages());
        customerPaginationDTO.setPageNumber(customerPage.getNumber());
        customerPaginationDTO.setNumberOfElements(customerPage.getNumberOfElements());
        customerPaginationDTO.setCustomerList(customerPage.getContent());

        return customerPaginationDTO;
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);

        if (customer.isEmpty()) throw new CustomerNotFoundException("Không tìm thấy customer với id: " + id);

        return modelMapper.map(customer.get(), CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> create(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        customerRepo.save(customer);

        return findAll();
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Không tìm thấy customer với id: " + id));

        customerDTO.setId(customer.getId());
        Customer customerCreated = customerRepo.save(modelMapper.map(customerDTO, Customer.class));

        return modelMapper.map(customerCreated, CustomerDTO.class);
    }

    @Override
    public void delete(Long id) {
        customerRepo.findById(id)
                    .orElseThrow(() -> new CustomerNotFoundException("Không tìm thấy customer với id: " + id));

        customerRepo.deleteById(id);
    }

}
