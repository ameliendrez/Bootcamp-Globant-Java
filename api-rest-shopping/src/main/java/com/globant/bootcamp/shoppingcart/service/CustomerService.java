package com.globant.bootcamp.shoppingcart.service;

import java.util.List;

import com.globant.bootcamp.shoppingcart.repository.CustomerRepository;
import com.globant.bootcamp.shoppingcart.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer add(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer get(Long customerId) {
        return this.customerRepository.findById(customerId).get();
    }

    public List<Customer> getAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    public Customer remove(Long customerId) {
        Customer remove = this.get(customerId);
        if (remove != null) {
            this.customerRepository.delete(remove);
            return remove;
        }
        return null;
    }

    public Customer setName(String name, Long customerId) {
        Customer customer = this.get(customerId);
        customer.setName(name);
        return this.customerRepository.save(customer);
    }

    public Customer setLastName(String lastName, Long customerId) {
        Customer customer = this.get(customerId);
        customer.setLastName(lastName);
        return this.customerRepository.save(customer);
    }

}