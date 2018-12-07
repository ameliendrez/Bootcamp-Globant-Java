package com.globant.bootcamp.shoppingcart.repository;

import com.globant.bootcamp.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
