package shoppingcart.controller;

import java.util.List;

import shoppingcart.dto.CustomerDto;
import shoppingcart.model.Customer;
import shoppingcart.service.CustomerService;
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
public class CustomerController {

	@Autowired
	private CustomerService customers;
	private Mapper mapper;

	@PostMapping("/customer")
	public CustomerDto addCustomer(@RequestBody CustomerDto customer) {
		Customer c = this.customers.add(this.mapper.convertCustomerToEntity(customer));
		return mapper.convertCustomerToDto(c);
	}

	@GetMapping("/customer/{id}")
	public CustomerDto getProduct(@PathVariable("id") Long customerId) {
		Customer customer = this.customers.get(customerId);
		return mapper.convertCustomerToDto(customer);
	}

	@DeleteMapping("/customer/{id}")
	public void removeCustomer(@PathVariable("id") long customerId) {
		this.customers.remove(customerId);
	}

	@GetMapping("/customers")
	public List<CustomerDto> getAllCustomers() {
		List<Customer> allCustomers = this.customers.getAll();
		return mapper.convertCustomerToDto(allCustomers);
	}

}