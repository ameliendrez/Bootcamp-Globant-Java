package shoppingcart.controller;

import java.util.List;

import shoppingcart.model.Cart;
import shoppingcart.model.Product;
import shoppingcart.model.Customer;
import shoppingcart.service.CartService;
import shoppingcart.service.ProductService;
import shoppingcart.service.CustomerService;
import shoppingcart.dto.CartDto;
import shoppingcart.dto.Mapper;

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
	private Mapper mapper;

	@PostMapping("/carts")
	public CartDto addCart(@RequestBody CartDto cart) {
		Cart c = this.carts.addCart(this.mapper.convertCartToEntity(cart));
		return mapper.convertCartToDto(c);
	}

	@GetMapping("/carts/{id}")
	public CartDto getCart(@PathVariable("id") Long cartId) {
		Cart cart = this.carts.getCart(cartId);
		return mapper.convertCartToDto(cart);
	}

	@DeleteMapping("/carts/{id}")
	public void removeCart(@PathVariable("cart_id") long cartId) {
		this.carts.removeCart(cartId);
	}

	@GetMapping("/carts")
	public List<CartDto> getAllCarts() {
		List<Cart> allCarts = this.carts.getCarts();
		return mapper.convertCartToDto(allCarts);
	}

	@PutMapping("/carts/{cartId}/products/{productId}")
	public CartDto addProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		Product product = this.products.get(productId);
		this.carts.addProduct(cartId, product);
		Cart cart = this.carts.getCart(cartId);
		return mapper.convertCartToDto(cart);
	}

	@DeleteMapping("/carts/{cartId}/products/{productId}")
	public void removeProduct(@PathVariable("cart_id") long cartId, @PathVariable("product_id") long productId) {
		Product product = this.products.get(productId);
		this.carts.removeProduct(cartId, product);
	}

	@PutMapping("/cart/{cartId}/customer/{customerId}")
	public CartDto setCustomer(@PathVariable("cartId") Long cartId, @PathVariable("customerId") Long customerId) {
		Customer customer = this.customers.get(customerId);
		this.carts.addCustomer(cartId, customer);
		Cart cart = this.carts.getCart(cartId);
		return mapper.convertCartToDto(cart);
	}
}