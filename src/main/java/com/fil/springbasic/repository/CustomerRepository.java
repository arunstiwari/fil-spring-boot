package com.fil.springbasic.repository;

import com.fil.springbasic.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> getCustomersById(Long id);

    Customer getCustomerById(Long id);

    Customer getCustomerByNameAndEmail(String name, String email);
}
