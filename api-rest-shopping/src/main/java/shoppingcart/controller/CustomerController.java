package shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import shoppingcart.dto.CustomerDto;
import shoppingcart.model.Customer;
import shoppingcart.service.CustomerService;

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
public class CustomerController {

	@Autowired
	private CustomerService customers;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/customer")
	public CustomerDto addCustomer(@RequestBody CustomerDto customer) {
		return this.convertToDto(this.customers.add(this.convertToEntity(customer)));
	}

	@GetMapping("/customer/{id}")
	public CustomerDto getProduct(@PathVariable("id") Long customerId) {
		return this.convertToDto(this.customers.get(customerId));
	}

	@DeleteMapping("/customer/{id}")
	public CustomerDto removeCustomer(@PathVariable("id") long customerId) {
		return this.convertToDto(this.customers.remove(customerId));
	}

	@GetMapping("/customers")
	public List<CustomerDto> getAllCustomers() {
		List<Customer> allCustomers = this.customers.getAll();
		List<CustomerDto> customersDto = new ArrayList<CustomerDto>();
		for (Customer customer : allCustomers) {
			customersDto.add(this.convertToDto(customer));
		}
		return customersDto;
	}

	private CustomerDto convertToDto(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);
	}

	private Customer convertToEntity(CustomerDto customerDto) {
		return modelMapper.map(customerDto, Customer.class);
	}
}