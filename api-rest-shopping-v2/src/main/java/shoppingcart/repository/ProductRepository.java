package shoppingcart.repository;

import java.util.List;
import shoppingcart.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String productName);
}
