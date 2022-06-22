package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.exception.*;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private final InMemoryCustomerStore customerStore;

    public SimpleCustomerService(InMemoryCustomerStore customerStore) {
        this.customerStore = customerStore;
    }

    @Override
    public Customer findById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if (id.isEmpty())
            throw new IllegalArgumentException("Customer id is null or blank");

        Customer customer = customerStore.findAll().stream()
                .filter(cs -> cs.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (customer == null)
            throw  new CustomerNotFoundException("Customer with id: " + id + " not found!");

        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        customer.setId(UUID.randomUUID().toString());
        customer.setName(standardized(customer.getName()));
        customer.setMobile(removeBlankMobile(customer.getMobile()));
        customer.setCreateDateTime(LocalDateTime.now());
        customer.setStatus(CustomerStatus.ACTIVE);

        checkValidCustomer(customer);

        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        customer.setMobile(removeBlankMobile(customer.getMobile()));
        customer.setName(standardized(customer.getName()));
        checkValidCustomer(customer);

        Customer existedCustomer = findById(customer.getId());

        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        Customer existedCustomer = findById(id);
        if (existedCustomer.getStatus() == CustomerStatus.ACTIVE) {
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
                .limit(Integer.parseInt(limit))
                .collect(Collectors.toList());

        return listSortedCustomer.isEmpty() ? Collections.<Customer>emptyList() : listSortedCustomer;
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        List<SummaryCustomerByAgeDTO> summaryCustomerByAgeDTOList = new ArrayList<>();

        Map<Object, List<Customer>> mapCustomerGroupByAge = customerStore.findAll().stream()
                .collect(Collectors.groupingBy(Customer::getAge));

        mapCustomerGroupByAge.entrySet()
                .stream().map(Map.Entry::getValue).collect(Collectors.toList())
                .stream().forEach(s -> {
                    SummaryCustomerByAgeDTO summaryCustomerByAgeDTO = new SummaryCustomerByAgeDTO();
                    summaryCustomerByAgeDTO.setAge(s.get(0).getAge());
                    summaryCustomerByAgeDTO.setCount(s.size());
                    summaryCustomerByAgeDTOList.add(summaryCustomerByAgeDTO);
                });

        return summaryCustomerByAgeDTOList.stream()
                .sorted(Comparator.comparingInt(SummaryCustomerByAgeDTO::getAge).reversed())
                .collect(Collectors.toList());
    }

    // check valid data customer obj
    private void checkValidCustomer(Customer customer) {
        // must standardized customer's name first
        if (customer.getName().isEmpty()
                || customer.getName() == null
                || customer.getName().trim().equals("")
                || !customer.getName().matches("^[a-z A-Z]{5,50}$")) {
            throw new InvalidCustomerException(customer, "Customer's name is invalid");
        }

        if (customer.getBirthDay() == null) {
            throw new InvalidCustomerException(customer, "Customer's birthday is null or blank");
        }

        if (customer.getAge() < 10 || customer.getAge() > 190) {
            throw new InvalidCustomerException(customer, "Customer's birthday is invalid");
        }

        if (!customer.getMobile().matches("^0[0-9]{1,10}")) {
            throw new InvalidCustomerException(customer, "Customer's mobile is invalid");
        }

        if (customer.getStatus() == null) {
            throw new InvalidCustomerException(customer, "Customer's status is empty");
        }

        if (isDuplicate(customer))
            throw new DuplicateCustomerException(customer, "Customer already exist in database");
    }

    // remove blank in mobile field
    private String removeBlankMobile(String mobile) {
        return mobile.trim().replaceAll("\\s+", "");
    }

    // standardized name
    private String standardized(String name) {
        String[] arr = name.trim().toLowerCase()
                .replaceAll("\\s+", " ")
                .split(" ");

        StringBuilder stringBuilder = new StringBuilder("");

        Arrays.stream(arr).forEach(s -> stringBuilder
                .append(String.valueOf(s.charAt(0)).toUpperCase())
                .append(s.substring(1))
                .append(" "));

        return stringBuilder.toString().trim();
    }

    // check duplicate customer
    private boolean isDuplicate(Customer customer) {
        return customerStore.findAll().stream()
                .anyMatch(cs -> cs.getMobile().equals(customer.getMobile()));
    }

    // fake data for testing
    public void initFakeData() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Customer customer1 = new Customer.Builder()
                .name("Le Thai Anh")
                .birthday(LocalDate.of(2000, Month.MAY, 15))
                .mobile("098183813")
                .createDateTime(localDateTime)
                .build();
        Customer customer2 = new Customer.Builder()
                .name(" NguyEn ChI      BINH      ")
                .birthday(LocalDate.of(2000, Month.MAY, 15))
                .mobile("098813531")
                .createDateTime(localDateTime)
                .build();
        Customer customer3 = new Customer.Builder()
                .name("Binh An")
                .birthday(LocalDate.of(2002, Month.MAY, 15))
                .mobile("0981  3813")
                .createDateTime(localDateTime)
                .build();
        Customer customer4 = new Customer.Builder()
                .name("Anh HAo an")
                .birthday(LocalDate.of(2003, Month.MAY, 15))
                .mobile("0981387    13")
                .createDateTime(localDateTime)
                .build();

        createCustomer(customer1);
        createCustomer(customer2);
        createCustomer(customer3);
        createCustomer(customer4);
    }

}
