package shoppingcart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import shoppingcart.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    public Product add(Product product) {
        if (product.getId() == null) {
            product.setId(this.counter.incrementAndGet());
        }
        this.products.put(product.getId(), product);
        return product;
    }

    public Product get(Long productId) {
        if (this.products.containsKey(productId)) {
            return this.products.get(productId);
        }
        return null;
    }

    public List<Product> getAll() {
        return (List<Product>) this.products.values();
    }

    public Product remove(Long productId) {
        Product remove = this.get(productId);
        if (remove != null) {
            this.products.remove(productId);
            return remove;
        }
        return null;
    }
}