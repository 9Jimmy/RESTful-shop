package com.jimmy9.shop.catalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {

    private UUID id;
    private final String name;
    private final int price;

    public Product(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("price") int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
