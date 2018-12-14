package com.globant.bootcamp.shoppingcart.dto;

public class CustomerDto {

    private Long id;
    private String lastName;
    private String name;

    public CustomerDto(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    public CustomerDto() {
    }

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
}