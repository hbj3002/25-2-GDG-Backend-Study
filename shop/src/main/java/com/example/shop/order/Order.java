package com.example.shop.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private String memberId;
    private String productId;
    private Long price;
    private String orderStatus;
    private String address;

    private String status;
    private LocalDateTime orderDate;

    public Order(String orderId, String memberId, String productId, Long price, String orderStatus, String address) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.productId = productId;
        this.price = price;
        this.orderStatus = orderStatus;
        this.address = address;
    }

    public void cancel() {
        if (this.status.equals("SHIPPED")) {
            throw new IllegalStateException("배송된 상품은 취소할 수 없습니다.");
        }
        this.status = "CANCEL";
    }
}