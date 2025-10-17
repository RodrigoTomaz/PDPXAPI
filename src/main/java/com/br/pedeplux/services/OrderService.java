package com.br.pedeplux.services;

import com.br.pedeplux.models.Order;
import com.br.pedeplux.repositories.OrderRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService implements Serializable {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Order findOrderById(Long orderId){
        return orderRepository.findById(orderId).orElseThrow(() -> new NoSuchElementException("Order not found!"));
    }
}
