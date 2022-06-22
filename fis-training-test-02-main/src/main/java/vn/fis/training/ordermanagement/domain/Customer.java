package vn.fis.training.ordermanagement.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="mobile")
    private String mobile;

    @Column(name="address")
    private String address;

}
