package com.palbol.order.services;

import com.palbol.order.dto.OrderPlusMinusRequestDTO;
import com.palbol.order.dto.OrderRequestDTO;
import com.palbol.order.dto.OrderResponseDTO;
import com.palbol.order.ex.OrderCreatedException;
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

    public Long add(OrderRequestDTO orderDTO) {
        return this.orderRepository.createOrder(
                orderDTO.getProductId(),
                orderDTO.getOrderQuantity(),
                orderDTO.getCustomerId())
                .orElseThrow(OrderCreatedException::new);
    }

    public void plus(OrderPlusMinusRequestDTO orderDTO) {
        this.orderRepository.updateOrder(orderDTO.getProductId(), orderDTO.getOrderId(), orderDTO.getOrderQuantity());
    }

    public void plus(Long orderId, Long productId) {
        this.orderRepository.updateOrder(productId, orderId, 1);
    }

    public void minus(Long orderId, Long productId) {
        this.orderRepository.updateOrder(productId, orderId, -1);
    }


    public void del(Long orderId, Long productId) {
        this.orderRepository.updateOrder(productId, orderId, 0);
    }

    @SuppressWarnings("unchecked")
    public OrderResponseDTO resume(Long orderId) {
        return new OrderResponseDTO();
    }

}
