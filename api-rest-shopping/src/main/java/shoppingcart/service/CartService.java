package shoppingcart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import shoppingcart.model.Cart;
import shoppingcart.model.Product;
import shoppingcart.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private Map<Long, Cart> carts = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    public Cart addCart(Cart cart) {
        if (cart.getId() == null) {
            cart.setId(this.counter.incrementAndGet());
        }
        this.carts.put(cart.getId(), cart);
        return cart;
    }

    public Cart getCart(Long cartId) {
        if (this.carts.containsKey(cartId)) {
            return this.carts.get(cartId);
        }
        return null;
    }

    public List<Cart> getCarts() {
        return (List<Cart>) this.carts.values();
    }

    public Cart removeCart(Long cartId) {
        Cart remove = this.getCart(cartId);
        if (remove != null) {
            this.carts.remove(cartId);
            return remove;
        }
        return null;
    }

    public Cart addCustomer(Long cartId, Customer customer) {
        Cart cart = this.getCart(cartId);
        if (cart != null) {
            cart.setCustomer(customer);
            return cart;
        }
        return null;
    }

    public Cart addProduct(Long cartId, Product product) {
        Cart cart = this.getCart(cartId);
        if (cart != null) {
            cart.addProduct(product);
            return cart;
        }
        return null;
    }

    public Cart removeProduct(Long cartId, Product product) {
        Cart cart = this.getCart(cartId);
        if (cart != null) {
            cart.removeProduct(product);
            return cart;
        }
        return null;
    }

}