package shoppingcart.controller;

import java.util.List;

import shoppingcart.model.Cart;
import shoppingcart.model.Product;
import shoppingcart.model.Customer;
import shoppingcart.service.CartService;
import shoppingcart.service.ProductService;
import shoppingcart.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class CartController {

	@Autowired
	private ProductService products;
	@Autowired
	private CartService carts;
	@Autowired
	private CustomerService customers;

	@PostMapping("/carts")
	public Cart addCart(@RequestBody Cart cart) {
		return this.carts.addCart(cart);
	}

	@GetMapping("/carts/{id}")
	public Cart getCart(@PathVariable("id") Long cartId) {
		return this.carts.getCart(cartId);
	}

	@DeleteMapping("/carts/{id}")
	public Cart removeCart(@PathVariable("cart_id") long cartId) {
		return this.carts.removeCart(cartId);
	}

	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		return this.carts.getCarts();
	}

	@PutMapping("/carts/{cartId}/products/{productId}")
	public Cart addProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		Product product = this.products.get(productId);
		return this.carts.addProduct(cartId, product);
	}

	@DeleteMapping("/carts/{cartId}/products/{productId}")
	public Cart removeProduct(@PathVariable("cart_id") long cartId, @PathVariable("product_id") long productId) {
		Product product = this.products.get(productId);
		return this.carts.removeProduct(cartId, product);
	}

	@PutMapping("/cart/{cartId}/customer/{customerId}")
	public Cart setCustomer(@PathVariable("cartId") Long cartId, @PathVariable("customerId") Long customerId) {
		Customer customer = this.customers.get(customerId);
		return this.carts.addCustomer(cartId, customer);
	}
}