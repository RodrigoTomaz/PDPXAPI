package com.br.pedeplux.repositories;

import com.br.pedeplux.models.OrderItem;
import com.br.pedeplux.models.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {}