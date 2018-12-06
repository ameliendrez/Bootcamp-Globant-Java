package shoppingcart.controller;

import java.util.List;

import shoppingcart.model.Product;
import shoppingcart.dto.ProductDto;
import shoppingcart.service.ProductService;
import shoppingcart.dto.Mapper;

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
	private Mapper mapper;

	@PostMapping("/product")
	public ProductDto addProducto(@RequestBody ProductDto product) {
		Product p = this.products.add(this.mapper.convertProductToEntity(product));
		return mapper.convertProductToDto(p);
	}

	@GetMapping("/product/{id}")
	public ProductDto getProduct(@PathVariable("id") Long productId) {
		Product product = this.products.get(productId);
		return mapper.convertProductToDto(product);
	}

	@DeleteMapping("/product/{id}")
	public void removeProduct(@PathVariable("id") long productId) {
		this.products.remove(productId);
	}

	@GetMapping("/products")
	public List<ProductDto> getAllProducts() {
		List<Product> allProducts = this.products.getAll();
		return mapper.convertProductToDto(allProducts);
	}
}