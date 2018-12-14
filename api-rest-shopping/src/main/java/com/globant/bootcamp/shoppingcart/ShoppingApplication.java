package com.globant.bootcamp.shoppingcart;

import com.globant.bootcamp.shoppingcart.service.*;
import com.globant.bootcamp.shoppingcart.model.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerService customers, CartService carts, ProductService products) {

        Customer c1 = new Customer();
        Customer c2 = new Customer();

        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        return (args) -> {

            customers.add(c1);
            customers.setName("Norberto", c1.getId());
            customers.setLastName("Napolitano", c1.getId());

            customers.add(c2);
            customers.setName("Ricardo", c2.getId());
            customers.setLastName("Mollo", c2.getId());

            customers.add(c2);
            customers.setName("Gustavo", c2.getId());
            customers.setLastName("Cerati", c2.getId());

            products.add(p1);
            products.setName("Lapiceras", p1.getId());
            products.setPrice(15.5, p1.getId());
            products.setQuantity(20, p1.getId());

            products.add(p2);
            products.setName("Carpetas", p2.getId());
            products.setPrice(25.0, p2.getId());
            products.setQuantity(10, p2.getId());

            products.add(p3);
            products.setName("Resaltadores", p3.getId());
            products.setPrice(20.3, p3.getId());
            products.setQuantity(16, p3.getId());

            products.add(p4);
            products.setName("Resma de hojas", p4.getId());
            products.setPrice(200.2, p4.getId());
            products.setQuantity(2, p4.getId());

            carts.addCart(cart1);
            carts.addCustomer(cart1.getId(), c1.getId());
            carts.addProduct(cart1.getId(), p1.getId());
            carts.addProduct(cart1.getId(), p2.getId());
            carts.addProduct(cart1.getId(), p3.getId());

            carts.addCart(cart2);
            carts.addCustomer(cart2.getId(), c2.getId());
            carts.addProduct(cart2.getId(), p4.getId());

            // Product np = products.get(L99);
        };
    }
}