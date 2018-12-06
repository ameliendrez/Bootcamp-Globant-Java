package shoppingcart.model;

import java.util.ArrayList;

public class Cart {

    private Long id;
    private Customer customer;
    private ArrayList<Product> products;

    public Cart(Long id, Customer customer, ArrayList<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (this.products == null)
            this.products = new ArrayList<Product>();

        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (product != null)
            this.products.remove(product);
    }
}