package com.br.pedeplux.services;

import com.br.pedeplux.models.Category;
import com.br.pedeplux.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    };

    public Category findCategoryById(Long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
}
