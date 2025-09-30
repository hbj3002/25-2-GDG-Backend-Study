package com.example.shop.order.dto;


import lombok.Getter;

@Getter
public class OrderCreateRequest {

    private String orderId;
    private String memberId;
    private String productId;
    private Long price;
    private String orderStatus;
    private String address;

    public OrderCreateRequest(String orderId, String memberId, String productId, Long price, String orderStatus, String address) {
    this.orderId = orderId;
    this.memberId = memberId;
    this.productId = productId;
    this.price = price;
    this.orderStatus = orderStatus;
    this.address = address;
    }
}


