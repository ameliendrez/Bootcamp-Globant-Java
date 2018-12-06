package shoppingcart.repository;

import java.util.List;
import shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findByName(String productName);
}
