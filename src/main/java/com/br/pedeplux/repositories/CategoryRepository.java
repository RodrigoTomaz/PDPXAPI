package com.br.pedeplux.repositories;

import com.br.pedeplux.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
