package com.palbol.order.controllers;

import com.palbol.order.dto.OrderPlusMinusRequestDTO;
import com.palbol.order.dto.OrderRequestDTO;
import com.palbol.order.dto.OrderResponseDTO;
import com.palbol.order.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/orders")
@Tag(name = "Product", description = "Apis de Orders de la APP")
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> resume(@PathVariable Long orderId) {
        return new ResponseEntity<>(orderService.resume(orderId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Long> add(@Valid @RequestBody OrderRequestDTO orderDTO) {
        return new ResponseEntity<>(orderService.add(orderDTO), HttpStatus.OK);
    }

    @PutMapping("/plus")
    public ResponseEntity<Void> plus(@Valid @RequestBody OrderPlusMinusRequestDTO orderDTO) {
        orderService.plus(orderDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/plus/{orderId}/{productId}")
    public ResponseEntity<Void> plus(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.plus(orderId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/minus/{orderId}/{productId}")
    public ResponseEntity<Void> minus(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.minus(orderId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/del/{orderId}/{productId}")
    public ResponseEntity<Void> del(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.del(orderId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
