package shoppingcart.controller;

import java.util.List;

import shoppingcart.model.Customer;
import shoppingcart.service.CustomerService;

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

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customers.add(customer);
	}

	@GetMapping("/customer/{id}")
	public Customer getProduct(@PathVariable("id") Long customerId) {
		return this.customers.get(customerId);
	}

	@DeleteMapping("/customer/{id}")
	public Customer removeCustomer(@PathVariable("id") long customerId) {
		return this.customers.remove(customerId);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return this.customers.getAll();
	}

}