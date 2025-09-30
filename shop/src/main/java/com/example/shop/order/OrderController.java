//Order 컨트롤러 계층
package com.example.shop.order;
import com.example.shop.order.Order;
import com.example.shop.order.OrderService;
import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")

public class OrderController {

    private final OrderService orderService;

    @PostMapping // 주문 정보 생성
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateRequest request) {
        Long orderId = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/" + orderId)).build();
    }

    @GetMapping  // 주문 목록 조회
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        //orderService에서 모든 Orders를 가져옴
        return ResponseEntity.ok(orders);
        // 가져온 것을 ok에 넣어줌
    }

    @GetMapping("/{orderId}")    //개별 주문 정보 상세 조회
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }


}
