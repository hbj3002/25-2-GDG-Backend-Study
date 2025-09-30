package com.example.shop.order;
import com.example.shop.order.Order;
import com.example.shop.order.OrderRepository;
import com.example.shop.order.dto.OrderCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request) {

        Order order = new Order(
                request.getOrderId(),
                request.getMemberId(),
                request.getProductId(),
                request.getPrice(),
                request.getOrderStatus(),
                request.getAddress()
        );

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        return order;

    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        orderRepository.deleteById(id);
    }
}



