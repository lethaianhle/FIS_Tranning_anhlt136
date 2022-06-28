package com.fis.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fis.app.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @Column(name = "order_date_time" , nullable = false)
    private LocalDateTime orderDateTime;

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    @JsonBackReference
    private List<OrderItem> orderItems;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(nullable = false)
    private OrderStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return getId() != null && Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
//                "version = " + getVersion() + ", " +
//                "createdAt = " + getCreatedAt() + ", " +
//                "createdBy = " + getCreatedBy() + ", " +
//                "modifiedAt = " + getModifiedAt() + ", " +
//                "modifiedBy = " + getModifiedBy() + ", " +
                "orderDateTime = " + getOrderDateTime() + ", " +
                "customer = " + getCustomer() + ", " +
                "totalAmount = " + getTotalAmount() + ", " +
                "status = " + getStatus() + ")";
    }

}
