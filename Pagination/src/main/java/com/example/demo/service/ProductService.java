package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomPageResponse;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public CustomPageResponse<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);

        // Extract content and page information
        List<Product> content = productPage.getContent();
        CustomPageResponse.PageInfo pageInfo = new CustomPageResponse.PageInfo(
                productPage.getSize(),
                productPage.getNumber(),
                productPage.getTotalElements(),
                productPage.getTotalPages()
        );

        return new CustomPageResponse<>(content, pageInfo);
    }
}