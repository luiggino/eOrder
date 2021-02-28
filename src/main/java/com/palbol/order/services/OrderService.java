package com.palbol.order.services;

import com.palbol.order.dto.OrderRequestDTO;
import com.palbol.order.dto.OrderResponseDTO;
import com.palbol.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @SuppressWarnings("unchecked")
    public Long add(OrderRequestDTO orderDTO) {
        return 1L;
    }

    @SuppressWarnings("unchecked")
    public void plus(Long orderId, Long productId) {

    }

    @SuppressWarnings("unchecked")
    public void minus(Long orderId, Long productId) {

    }

    @SuppressWarnings("unchecked")
    public void del(Long orderId, Long productId) {

    }

    @SuppressWarnings("unchecked")
    public OrderResponseDTO resume(Long orderId) {
        return new OrderResponseDTO();
    }

}
