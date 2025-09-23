package com.fil.springbasic;

import com.fil.springbasic.entity.Customer;
import com.fil.springbasic.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository ;

    @Test
    public  void testCreateCustomer(){

        Long id = null;
        String name = "customer-1";
        String email = "customer1@xyz.com";
        Customer customer = new Customer(id, name, email);
        Customer createdCustomer = customerRepository.save(customer);
        Assertions.assertNotNull(createdCustomer);
        Assertions.assertNotNull(createdCustomer.getId());
        Assertions.assertEquals(name, createdCustomer.getName());
        Assertions.assertEquals(email, createdCustomer.getEmail());
        System.out.println(createdCustomer);
    }

    @Test
    public void fetchCustomerByCustomerId(){
        Long id = null;
        String name = "customer-1";
        String email = "customer1@xyz.com";
        Customer customer = new Customer(id, name, email);
        Customer secondCustomer = new Customer(null, "customer-2", "customer2@xyz.com");
        Customer createdCustomer = customerRepository.save(customer);
        Customer secondCreatedCustomer = customerRepository.save(secondCustomer);

        List<Customer> customersById = customerRepository.getCustomersById(createdCustomer.getId());
        Assertions.assertEquals(1, customersById.size());

        Customer searchedCustomer = customerRepository.getCustomerById(createdCustomer.getId());
        Assertions.assertEquals(createdCustomer, searchedCustomer);

        Customer searchedCustomer1 = customerRepository.getCustomerByNameAndEmail(createdCustomer.getName(), createdCustomer.getEmail());
        Assertions.assertEquals(createdCustomer, searchedCustomer1);
    }
}
