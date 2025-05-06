package com.example.groceryapi.service;

import com.example.groceryapi.entity.Customer;
import com.example.groceryapi.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        customer.setPhone(customerDetails.getPhone());
        return customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}