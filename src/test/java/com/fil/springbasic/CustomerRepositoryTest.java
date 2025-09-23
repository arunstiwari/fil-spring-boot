package com.fil.springbasic;

import com.fil.springbasic.entity.Customer;
import com.fil.springbasic.entity.Order;
import com.fil.springbasic.repository.CustomerRepository;
import com.fil.springbasic.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository ;
    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setup(){
        customerRepository.deleteAll();
    }

    @Test
    void testCreateCustomer(){

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
    void fetchCustomerByCustomerId(){
        Long id = null;
        String name = "customer-1";
        String email = "customer1@xyz.com";
        Customer customer = new Customer(id, name, email);
        Customer secondCustomer = new Customer(null, "customer-2", "customer2@xyz.com");
        Customer createdCustomer = customerRepository.save(customer);
        customerRepository.save(secondCustomer);

        List<Customer> customersById = customerRepository.getCustomersById(createdCustomer.getId());
        Assertions.assertEquals(1, customersById.size());

        Customer searchedCustomer = customerRepository.getCustomerById(createdCustomer.getId());
        Assertions.assertEquals(createdCustomer.getId(), searchedCustomer.getId());

        Customer searchedCustomer1 = customerRepository.getCustomerByNameAndEmail(createdCustomer.getName(), createdCustomer.getEmail());
        Assertions.assertEquals(createdCustomer.getId(), searchedCustomer1.getId());

        List<Customer> customers = customerRepository.findAll();
        Assertions.assertEquals(2, customers.size());
    }

    @Test
    void deleteACustomerById(){
        Long id = null;
        String name = "customer-1";
        String email = "customer1@xyz.com";
        Customer customer = new Customer(id, name, email);
        Customer secondCustomer = new Customer(null, "customer-2", "customer2@xyz.com");
        Customer createdCustomer = customerRepository.save(customer);
        customerRepository.save(secondCustomer);

        customerRepository.deleteById(createdCustomer.getId());
        List<Customer> customers = customerRepository.findAll();
        Assertions.assertEquals(1, customers.size());
    }

    @Test
    void aGivenCustomerHasMultipleOrders(){
        Customer customer = new Customer(null, "customer-1", "customer1@xyz.com");

        Customer savedCustomer = customerRepository.save(customer);
        Order order1 = new Order(null, "desc1", customer);
        Order order2 = new Order(null, "desc2", customer);
        savedCustomer.addOrder(order1);
        savedCustomer.addOrder(order2);
        Customer customer1 = customerRepository.save(savedCustomer);

        Customer retrievedCustomer = customerRepository.getCustomerById(customer1.getId());
        List<Order> orders = retrievedCustomer.getOrders();
        Assertions.assertEquals(2, orders.size());
    }
}
