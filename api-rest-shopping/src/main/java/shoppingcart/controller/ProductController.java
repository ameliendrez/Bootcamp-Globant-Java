package shoppingcart.controller;

import java.util.List;

import shoppingcart.model.Product;
import shoppingcart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class ProductController {

	@Autowired
	private ProductService products;

	@PostMapping("/product")
	public Product addProducto(@RequestBody Product product) {
		return this.products.add(product);
	}

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") Long productId) {
		return this.products.get(productId);
	}

	@DeleteMapping("/product/{id}")
	public Product removeProduct(@PathVariable("id") long productId) {
		return this.products.remove(productId);
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return this.products.getAll();
	}
}