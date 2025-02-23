package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomPageResponse;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(@RequestParam int page, @RequestParam int size) {
        CustomPageResponse<Product> response = productService.getProducts(page, size);

        if (response.getContent().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No more products available. Maximum page reached.");
        }

        return ResponseEntity.ok(response);
    }
}