package com.globant.bootcamp.shoppingcart.service;

import java.util.List;

import com.globant.bootcamp.shoppingcart.repository.*;
import com.globant.bootcamp.shoppingcart.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;

    public Cart addCart(Cart cart) {
        return this.cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        return this.cartRepository.findById(cartId).get();
    }

    public List<Cart> getCarts() {
        return (List<Cart>) this.cartRepository.findAll();
    }

    public Cart removeCart(Long cartId) {
        Cart remove = this.getCart(cartId);
        if (remove != null) {
            this.cartRepository.delete(remove);
            return remove;
        }
        return null;
    }

    public Cart addCustomer(Long cartId, Long customerId) {
        Cart cart = this.getCart(cartId);
        if (cart != null) {
            cart.setCustomer(this.customerRepository.findById(customerId).get());
        }
        return this.cartRepository.save(cart);
    }

    public Cart addProduct(Long cartId, Long productId) { // Comprobar si debo mandar id
        Cart cart = this.getCart(cartId);
        if (cart != null) {
            cart.addProduct(this.productRepository.findById(productId).get());
        }
        return this.cartRepository.save(cart);
    }

    public Cart removeProduct(Long cartId, Long productId) {
        Cart cart = this.getCart(cartId);
        if (cart != null) {
            cart.removeProduct(this.productRepository.findById(productId).get());
        }
        return this.cartRepository.save(cart);
    }

}