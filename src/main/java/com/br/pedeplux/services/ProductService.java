package com.br.pedeplux.services;

import com.br.pedeplux.models.Product;
import com.br.pedeplux.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found!"));
    }
}
