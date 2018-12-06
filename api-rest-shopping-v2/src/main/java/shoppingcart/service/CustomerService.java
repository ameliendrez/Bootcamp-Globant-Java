package shoppingcart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import shoppingcart.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private Map<Long, Customer> customers = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    public Customer add(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(this.counter.incrementAndGet());
        }
        this.customers.put(customer.getId(), customer);
        return customer;
    }

    public Customer get(Long customerId) {
        if (this.customers.containsKey(customerId)) {
            return this.customers.get(customerId);
        }
        return null;
    }

    public List<Customer> getAll() {
        return (List<Customer>) this.customers.values();
    }

    public Customer remove(Long customerId) {
        Customer remove = this.get(customerId);
        if (remove != null) {
            this.customers.remove(customerId);
            return remove;
        }
        return null;
    }

}