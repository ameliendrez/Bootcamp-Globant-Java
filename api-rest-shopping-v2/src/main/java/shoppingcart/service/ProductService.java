package shoppingcart.service;

import java.util.List;

import shoppingcart.model.Product;
import shoppingcart.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product) {
        this.productRepository.save(product);
        return product;
    }

    public Product get(Long productId) {
        return this.productRepository.findById(productId).get();
    }

    public List<Product> getAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    public Product remove(Long productId) {
        Product remove = this.get(productId);
        if (remove != null) {
            this.productRepository.delete(remove);
        }
        return null;
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