package com.globant.bootcamp.shoppingcart.service;

import java.util.List;

import com.globant.bootcamp.shoppingcart.exception.ProductNotFoundException;
import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product){
        if(product != null)
            return this.productRepository.save(product);
            
        throw new IllegalArgumentException("No exist this product");
    }

    public Product get(Long productId) {
        if(this.productRepository.existsById(productId))
            return this.productRepository.findById(productId).get();
            
        throw new ProductNotFoundException(productId);
    }

    public List<Product> getAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    public Product remove(Long productId) {
        if(this.productRepository.existsById(productId)){
            Product remove = this.get(productId);
            if (remove != null) {
                this.productRepository.delete(remove);
            }
            return null;
        }
        throw new ProductNotFoundException(productId);
    }

    public Product setName(String name, Long productId) {
        Product product = this.get(productId);
        product.setName(name);
        return this.productRepository.save(product);
    }

    public Product setPrice(Double price, Long productId) {
        Product product = this.get(productId);
        product.setPrice(price);
        return this.productRepository.save(product);
    }

    public Product setQuantity(int quantity, Long productId) {
        Product product = this.get(productId);
        product.setQuantity(quantity);
        return this.productRepository.save(product);
    }
}