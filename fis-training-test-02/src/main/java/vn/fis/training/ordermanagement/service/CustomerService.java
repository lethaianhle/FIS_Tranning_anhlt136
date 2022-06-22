package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Long customerId) throws CustomerNotFoundException;

    List<Customer> findAll();

    Customer findByMobileNumber(String mobileNumber) throws CustomerNotFoundException;
}
