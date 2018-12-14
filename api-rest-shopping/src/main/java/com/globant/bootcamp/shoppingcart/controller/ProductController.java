package com.globant.bootcamp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import com.globant.bootcamp.shoppingcart.model.Product;
import com.globant.bootcamp.shoppingcart.dto.ProductDto;
import com.globant.bootcamp.shoppingcart.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart/products")
public class ProductController {

	@Autowired
	private ProductService products;
	@Autowired
	private ModelMapper modelMapper;

	// @PostMapping("/")
	// public ProductDto addProducto(@RequestBody ProductDto product) {
	// return this.convertToDto(this.products.add(this.convertToEntity(product)));
	// }

	@PostMapping("/")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
		return ResponseEntity.created(null).body(this.convertToDto(this.products.add(this.convertToEntity(product))));
	}

	@GetMapping("/{id}")
	public ProductDto getProduct(@PathVariable("id") Long productId){
		return this.convertToDto(this.products.get(productId));
	}

	@DeleteMapping("/{id}")
	public ProductDto removeProduct(@PathVariable("id") long productId) {
		return this.convertToDto(this.products.remove(productId));
	}

	@GetMapping("/")
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