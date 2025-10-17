package com.br.pedeplux.controllers;

import com.br.pedeplux.models.Category;
import com.br.pedeplux.repositories.CategoryRepository;
import com.br.pedeplux.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){
        return ResponseEntity.ok().body(categoryService.findAllCategories());
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long categoryId){
        return ResponseEntity.ok().body(categoryService.findCategoryById(categoryId));
    }
}
