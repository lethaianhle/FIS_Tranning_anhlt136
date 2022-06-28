package com.fis.app.controller;

import com.fis.app.core.Result;
import com.fis.app.dto.CustomerDTO;
import com.fis.app.dto.CustomerPaginationDTO;
import com.fis.app.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public Result<List<CustomerDTO>> findAll() {
        try {
            List<CustomerDTO> result = customerService.findAll();

            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @GetMapping(params = { "page", "size" })
    public Result<CustomerPaginationDTO> findAll(@RequestParam("page") int page,
                                                 @RequestParam("size") int size) {
        try {
            CustomerPaginationDTO result = customerService.findAll(page, size);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @GetMapping("/{id}")
    public Result<CustomerDTO> findById(@PathVariable Long id) {
        try {
            CustomerDTO result = customerService.findById(id);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @PutMapping
    public Result<List<CustomerDTO>> create(@RequestBody CustomerDTO customerDTO) {
        try {
            List<CustomerDTO> result = customerService.create(customerDTO);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

    @PostMapping("/{id}")
    public Result<CustomerDTO> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        try {
            CustomerDTO result = customerService.update(id, customerDTO);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result<Object> delete(@PathVariable Long id) {
        try {
            customerService.delete(id);
            return Result.success("Xóa thành công customer với id: " + id);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }

}
