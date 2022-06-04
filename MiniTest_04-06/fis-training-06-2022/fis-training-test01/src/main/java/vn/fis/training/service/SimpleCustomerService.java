package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.*;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

    /**
     * @param id : Id Customer muon tim kiem
     * @return : Customer trong he thong
     * @throws : CustomerNotFoundException trong truong hop khong tim duoc Customer tuong ung voi Id
     * @throws IllegalArgumentException trong truong hop id la null, rong
     */
    @Override
    public Customer findById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if (id.isEmpty() || id == null)
            throw new IllegalArgumentException("Customer id is null or blank");

        Customer customer = customerStore.findById(id);

        if (customer == null)
            throw  new CustomerNotFoundException("Customer with id: " + id + " not found!");

        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        customer.setName(standardized(customer.getName()));
        checkValidCustomer(customer);

        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        customer.setName(standardized(customer.getName()));
        checkValidCustomer(customer);

        Customer existedCustomer = customerStore.findById(customer.getId());
        if (existedCustomer == null)
            throw  new CustomerNotFoundException("Customer with id: " + customer.getId() + " not found!");

        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        Customer existedCustomer = findById(id);
        if (existedCustomer.getStatus().equals("ACTIVE")) {
            throw new InvalidCustomerStatusException(existedCustomer, "Can not delete customer on actived");
        }

        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        List<Customer> listSortedCustomer = customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());

        return listSortedCustomer.isEmpty() ? Collections.<Customer>emptyList() : listSortedCustomer;
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        List<Customer> listSortedCustomer = customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());

        return listSortedCustomer.isEmpty() ? Collections.<Customer>emptyList() : listSortedCustomer;
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        List<Customer> listSortedCustomer = customerStore.findAll().stream()
                .filter(customer -> customer.getName().contains(custName))
                .sorted(Comparator.comparing(Customer::getName))
                .limit(Integer.valueOf(limit))
                .collect(Collectors.toList());

        return listSortedCustomer.isEmpty() ? Collections.<Customer>emptyList() : listSortedCustomer;
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    // must standardized customer name first
    private void checkValidCustomer(Customer customer) {
        if (customer.getName().isEmpty()
                || customer.getName() == null
                || customer.getName().trim().equals("")
                || customer.getName().length() < 5
                || customer.getName().length() > 50
                || !customer.getName().matches("[a-zA-Z]+")) {
            throw new InvalidCustomerException(customer, "Customer's name is invalid");
        }

        if (customer.getBirthDay() == null) {
            throw new InvalidCustomerException(customer, "Customer's birthday is blank or empty");
        }

        if (customer.getMobile().matches("[0-9]{10}")) {
            throw new InvalidCustomerException(customer, "Customer's mobile is invalid");
        }

        if (customer.getStatus() == null) {
            throw new InvalidCustomerException(customer, "Customer's status is empty");
        }

        if (isDuplicate(customer))
            throw new DuplicateCustomerException(customer, "Customer already exist in database");

    }

    // xoa khoang trang thua
    private String removeBlank(String str) {
        String string = str.trim().toLowerCase();
        string = string.replaceAll("\\s+", " ");
        return string;
    }

    private String standardized(String name) {
        // xoa khoang trang thua
        String standardized = removeBlank(name);

        // viet hoa chu cai dau
        String[] temp = standardized.split(" ");

        standardized = "";
        for (int i = 0; i < temp.length; i++) {
            standardized += String.valueOf(temp[i].charAt(0)).toUpperCase()
                    + temp[i].substring(1);

            if (i < temp.length - 1)
                standardized += " ";
        }

        return standardized;
    }

    private boolean isDuplicate(Customer customer) {
        List<Customer> listCustomer = customerStore.findAll();
        return listCustomer.stream()
                .anyMatch(cs -> cs.getMobile().equals(customer.getMobile()));
    }

}
