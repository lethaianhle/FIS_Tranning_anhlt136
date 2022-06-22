package vn.fis.training.ordermanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tbl_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;
}
