package com.br.pedeplux.controllers;

import com.br.pedeplux.models.Order;
import com.br.pedeplux.repositories.OrderRepository;
import com.br.pedeplux.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders(){
        return ResponseEntity.ok().body(orderService.findAllOrders());
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long orderId){
        return ResponseEntity.ok().body(orderService.findOrderById(orderId));
    }
}
