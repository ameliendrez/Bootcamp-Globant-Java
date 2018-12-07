package com.globant.bootcamp.shoppingcart.repository;

import com.globant.bootcamp.shoppingcart.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}