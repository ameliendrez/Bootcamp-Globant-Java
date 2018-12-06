package shoppingcart.dto;

import shoppingcart.model.Cart;
import shoppingcart.model.Customer;
import shoppingcart.model.Product;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class Mapper {
    ModelMapper modelMapper;

    // MAPPER DE PRODUCTOS
    public Product convertProductToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    public ProductDto convertProductToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public List<ProductDto> convertProductToDto(List<Product> products) {
        List<ProductDto> productsDto = new ArrayList<ProductDto>();
        for (Product product : products) {
            productsDto.add(this.convertProductToDto(product));
        }
        return productsDto;
    }

    // MAPPER DE CUSTOMERS
    public Customer convertCustomerToEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    public CustomerDto convertCustomerToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    public List<CustomerDto> convertCustomerToDto(List<Customer> customers) {
        List<CustomerDto> customersDto = new ArrayList<CustomerDto>();
        for (Customer customer : customers) {
            customersDto.add(this.convertCustomerToDto(customer));
        }
        return customersDto;
    }

    // MAPPER DE CARTS
    public Cart convertCartToEntity(CartDto cartDto) {
        return modelMapper.map(cartDto, Cart.class);
    }

    public CartDto convertCartToDto(Cart cart) {
        return modelMapper.map(cart, CartDto.class);
    }

    public List<CartDto> convertCartToDto(List<Cart> carts) {
        List<CartDto> cartsDto = new ArrayList<CartDto>();
        for (Cart cart : carts) {
            cartsDto.add(this.convertCartToDto(cart));
        }
        return cartsDto;
    }

}