package com.br.pedeplux.controllers;

import com.br.pedeplux.models.Product;
import com.br.pedeplux.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable Long productId){
        return ResponseEntity.ok().body(productService.findProductById(productId));
    }
}
