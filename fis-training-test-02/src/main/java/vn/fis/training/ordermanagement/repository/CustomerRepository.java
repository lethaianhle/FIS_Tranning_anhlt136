package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.fis.training.ordermanagement.domain.Customer;

import java.util.Optional;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customer c WHERE c.mobile = ?1", nativeQuery = true)
    Optional<Customer> findByMobile(String mobile);

}
