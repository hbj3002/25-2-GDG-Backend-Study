package com.example.shop.product.dto;

import lombok.Getter;

@Getter
public class ProductUpdateRequest {
    private String name;
    private String description;
    private Long price;
    private Integer quantity;
    private String category;

    public ProductUpdateRequest(String name, String description, Long price, Integer quantity, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

}

