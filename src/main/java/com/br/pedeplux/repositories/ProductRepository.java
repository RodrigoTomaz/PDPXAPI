package com.br.pedeplux.repositories;

import com.br.pedeplux.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
