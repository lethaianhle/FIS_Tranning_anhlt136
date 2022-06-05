package vn.fis.training;


import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.service.CustomerService;
import vn.fis.training.service.SimpleCustomerService;
import vn.fis.training.service.SummaryCustomerByAgeDTO;
import vn.fis.training.store.InMemoryCustomerStore;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerManagementApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Fis Java Training Course!" );

        Scanner sc = new Scanner(System.in);
        InMemoryCustomerStore customerStore = new InMemoryCustomerStore();
        SimpleCustomerService customerService = new SimpleCustomerService(customerStore);
        customerService.initFakeData();

        System.out.println("");
        System.out.println("------Danh sach customer order asc------");
        List<Customer> listAllCustomer = customerService.findAllOrderByNameAsc();
        listAllCustomer.forEach(cs -> System.out.println(cs));


        System.out.println("");
        System.out.println("------Danh sach customer group by age desc(dto obj)------");
        List<SummaryCustomerByAgeDTO> summaryCustomerByAgeDTOList = customerService.summaryCustomerByAgeOrderByAgeDesc();
        summaryCustomerByAgeDTOList.forEach(dto -> System.out.println(dto));

        System.out.println("");
        System.out.println("------Danh sach customer order asc limit 2------");
        List<Customer> listAllCustomerOrderAscLimit = customerService.findAllOrderByNameLimit(2);
        listAllCustomerOrderAscLimit.forEach(cs -> System.out.println(cs));

        System.out.println("");
        System.out.print("Nhap id can tim: ");
        Customer foundCustomer = customerService.findById(sc.nextLine());
        System.out.println(foundCustomer);

        System.out.println("");
        System.out.print("Nhap id can chinh sua(auto set status to INACTIVE for testing delete): ");
        Customer existedCustomer = customerService.findById(sc.nextLine());
        Customer customerForUpdate = new Customer.Builder().id(existedCustomer.getId())
                .name("Updated Customer")
                .birthday(LocalDate.of(2008, Month.MAY, 28))
                .status(CustomerStatus.INACTIVE)
                .mobile("09")
                .createDateTime(existedCustomer.getCreateDateTime())
                .build();

        Customer updatedCustomer = customerService.updateCustomer(customerForUpdate);
        System.out.println("Updated -> " + updatedCustomer);

        System.out.println("--> Danh sach customer sau khi update:");
        List<Customer> listAllCustomerAfterUpdate = customerService.findAllOrderByNameAsc();
        listAllCustomerAfterUpdate.forEach(cs -> System.out.println(cs));

        System.out.println("");
        System.out.print("Nhap id can xoa: ");
        customerService.deleteCustomerById(sc.nextLine());
        System.out.println("--> Danh sach customer sau khi xoa:");
        List<Customer> listAllCustomerAfterDelete = customerService.findAllOrderByNameAsc();
        listAllCustomerAfterDelete.forEach(cs -> System.out.println(cs));

        System.out.println("");
        System.out.print("Nhap ten can tim: ");
        String name = sc.nextLine();
        System.out.print("Nhap so luong limit: ");
        String limit = sc.nextLine();
        List<Customer> listAllCustomerByNameLikeOrderByNameAsc
                = customerService.findAllCustomerByNameLikeOrderByNameAsc(name, limit);
        if (listAllCustomerByNameLikeOrderByNameAsc.isEmpty()) {
            System.out.println("--> Khong tim thay customer phu hop");
        } else {
            System.out.println("--> Danh sach customer tim duoc:");
            listAllCustomerByNameLikeOrderByNameAsc.forEach(cs -> System.out.println(cs));
        }

    }
    // TODO: Implement method to test all CustomerService
}
