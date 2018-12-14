package com.globant.bootcamp.shoppingcart.exception;

import lombok.Getter;

@Getter 
public class ProductNotFoundException extends RuntimeException {
  private final Long id;
  public ProductNotFoundException(final long id) {
    super("Producto no encontrado con el id: " + id);
    this.id = id;
  }
  
}