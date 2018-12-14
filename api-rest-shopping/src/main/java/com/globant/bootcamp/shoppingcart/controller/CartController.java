package com.globant.bootcamp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import com.globant.bootcamp.shoppingcart.model.Cart;
import com.globant.bootcamp.shoppingcart.service.CartService;
import com.globant.bootcamp.shoppingcart.dto.CartDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@RequestMapping("/shoppingCart/carts")
public class CartController {

	@Autowired
	private CartService carts;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/")
	public CartDto addCart(@RequestBody CartDto cart) {
		return this.convertToDto(this.carts.addCart(this.convertToEntity(cart)));
	}

	@GetMapping("/{id}")
	public CartDto getCart(@PathVariable("id") Long cartId) {
		return this.convertToDto(this.carts.getCart(cartId));
	}

	@DeleteMapping("/{id}")
	public CartDto removeCart(@PathVariable("cart_id") long cartId) {
		return this.convertToDto(this.carts.removeCart(cartId));
	}

	@GetMapping("/")
	public List<CartDto> getAllCarts() {
		List<Cart> allCarts = this.carts.getCarts();
		List<CartDto> cartsDto = new ArrayList<CartDto>();
		for (Cart cart : allCarts) {
			cartsDto.add(this.convertToDto(cart));
		}
		return cartsDto;
	}

	@PutMapping("/{cartId}/{productId}")
	public CartDto addProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		return this.convertToDto(this.carts.addProduct(cartId, productId));
	}

	@DeleteMapping("/{cartId}/{productId}")
	public CartDto removeProduct(@PathVariable("cart_id") long cartId, @PathVariable("product_id") long productId) {
		return this.convertToDto(this.carts.removeProduct(cartId, productId));
	}

	@PutMapping("/{cartId}/{customerId}")
	public CartDto setCustomer(@PathVariable("cartId") Long cartId, @PathVariable("customerId") Long customerId) {
		return this.convertToDto(this.carts.addCustomer(cartId, customerId));
	}

	private CartDto convertToDto(Cart cart) {
		return modelMapper.map(cart, CartDto.class);
	}

	private Cart convertToEntity(CartDto cartDto) {
		return modelMapper.map(cartDto, Cart.class);
	}
}