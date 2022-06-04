package vn.fis.training.store;

import vn.fis.training.domain.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public final class InMemoryCustomerStore {
    /**
     *  Map dung de lu tru customer trong he thong
     */
    private final Map<String, Customer> mapCustomer = new HashMap<>();

    public InMemoryCustomerStore() {
        this.initValue();
    }

    /**
     * @param customer doi tuong customer (da duoc chuan hoa truoc do)
     * @return Customer: Doi tuong customer sau khi da duoc luu thanh cong vao he thong
     * @throws vn.fis.training.exception.ApplicationException tuong ung.
     */
    public Customer insertOrUpdate(Customer customer) {
        mapCustomer.put(customer.getId(), customer);
        return  mapCustomer.get(customer.getId());
    }

    /**
     * @return : tra ve toan bo danh sach customer trong he thong
     */
    public List<Customer> findAll() {
        return mapCustomer.entrySet()
                .stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    /**
     * @param id: Id cua customer muon delete
     */
    public void deleteById(String id) {
        mapCustomer.remove(id);
    }

    public Customer findById(String id) {
        return mapCustomer.get(id);
    }

    public void initValue() {
        LocalDate localDate1 = LocalDate.now();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        
        Customer customer1 = new Customer.Builder().id(UUID.randomUUID().toString())
                .name("Le Thai Anh 1")
                .birthday(localDate1)
                .mobile("09813813531")
                .createDateTime(localDateTime1)
                .build();
        Customer customer2 = new Customer.Builder().id(UUID.randomUUID().toString())
                .name("Le Thai Anh 2")
                .birthday(localDate1)
                .mobile("09813813531")
                .createDateTime(localDateTime1)
                .build();
        Customer customer3 = new Customer.Builder().id(UUID.randomUUID().toString())
                .name("Le Thai Anh 3")
                .birthday(localDate1)
                .mobile("09813813531")
                .createDateTime(localDateTime1)
                .build();
        Customer customer4 = new Customer.Builder().id(UUID.randomUUID().toString())
                .name("Le Thai Anh 4")
                .birthday(localDate1)
                .mobile("09813813531")
                .createDateTime(localDateTime1)
                .build();

        mapCustomer.put(customer1.getId(), customer1);
        mapCustomer.put(customer2.getId(), customer2);
        mapCustomer.put(customer3.getId(), customer3);
        mapCustomer.put(customer4.getId(), customer4);
    }
}
