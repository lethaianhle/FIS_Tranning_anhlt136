package com.fis.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(nullable = false)
    @NotNull
    @Size(min=10, max=100)
    private String name;

    @Column(nullable = false, unique = true)
    @NotNull
    @Pattern(regexp="^0[0-9]{1,10}")
    private String mobile;

    @Column(nullable = false)
    @NotNull
    @Size(min=10, max=100)
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return getId() != null && Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "name = " + getName() + ", " +
                "mobile = " + getMobile() + ", " +
                "address = " + getAddress() + ")";
    }

}
