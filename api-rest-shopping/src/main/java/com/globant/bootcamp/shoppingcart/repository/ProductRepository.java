package com.globant.bootcamp.shoppingcart.repository;

import com.globant.bootcamp.shoppingcart.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
