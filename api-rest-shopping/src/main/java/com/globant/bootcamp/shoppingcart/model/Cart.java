package com.globant.bootcamp.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    public Cart(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<Product>();
    }

    public Cart() {
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

    public void addProduct(Product product) {
        if (this.products == null)
            this.products = new ArrayList<Product>();

        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (product != null)
            this.products.remove(product);
    }

    @Override
    public String toString() {
        return String.format("Cart[id=%d, customer='%s', products='%s']", id, customer, products);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((products == null) ? 0 : products.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Cart other = (Cart) obj;
        if (this.id != other.id)
            return false;
        if (this.products == null) {
            if (other.products != null)
                return false;
        } else if (!this.products.equals(other.products))
            return false;
        if (this.customer == null) {
            if (other.customer != null)
                return false;
        } else if (!this.customer.equals(other.customer))
            return false;
        return true;
    }
}