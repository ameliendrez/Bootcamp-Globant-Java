package com.globant.bootcamp.shoppingcart.dto;

import java.util.List;

import com.globant.bootcamp.shoppingcart.model.Customer;
import com.globant.bootcamp.shoppingcart.model.Product;

public class CartDto {

    private Long id;
    private Customer customer;
    private List<Product> products;

    public CartDto(Customer customer) {
        this.customer = customer;
    };

    public CartDto() {
    };

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}