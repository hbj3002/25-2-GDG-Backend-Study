package com.example.shop.product.dto;


import lombok.Getter;

@Getter
public class ProductCreateRequest {
    private String productId;
    private String name;
    private String description;
    private Long price;
    private Long quantity;
    private String category;

    public ProductCreateRequest(String productId, String name, String description, Long price, Long quantity, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

