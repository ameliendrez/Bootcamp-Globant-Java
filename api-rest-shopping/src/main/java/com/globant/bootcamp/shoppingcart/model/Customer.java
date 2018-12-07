package com.globant.bootcamp.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String name;

    public Customer(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    public Customer() {
    };

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, name='%s', lastName='%s']", id, name, lastName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Customer other = (Customer) obj;
        if (this.id != other.id)
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (this.name != other.name)
            return false;
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (this.lastName != other.lastName)
            return false;
        return true;
    }

}