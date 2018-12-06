package shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import shoppingcart.model.Product;
import shoppingcart.dto.ProductDto;
import shoppingcart.service.ProductService;

import org.modelmapper.ModelMapper;
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
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/product")
	public ProductDto addProducto(@RequestBody ProductDto product) {
		return this.convertToDto(this.products.add(this.convertToEntity(product)));
	}

	@GetMapping("/product/{id}")
	public ProductDto getProduct(@PathVariable("id") Long productId) {
		return this.convertToDto(this.products.get(productId));
	}

	@DeleteMapping("/product/{id}")
	public ProductDto removeProduct(@PathVariable("id") long productId) {
		return this.convertToDto(this.products.remove(productId));
	}

	@GetMapping("/products")
	public List<ProductDto> getAllProducts() {
		List<Product> allProducts = this.products.getAll();
		List<ProductDto> productsDto = new ArrayList<ProductDto>();
		for (Product product : allProducts) {
			productsDto.add(this.convertToDto(product));
		}
		return productsDto;
	}

	public Product convertToEntity(ProductDto productDto) {
		return modelMapper.map(productDto, Product.class);
	}

	public ProductDto convertToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
}