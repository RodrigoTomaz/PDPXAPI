package com.br.pedeplux.repositories;

import com.br.pedeplux.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}