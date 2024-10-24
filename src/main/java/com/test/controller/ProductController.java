package com.test.controller;

import com.test.controller.request.ProductRequestBody;
import com.test.controller.response.ProductResponseBody;
import com.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponseBody> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductRequestBody requestBody) {
        log.info("Request: {}", requestBody);
        productService.saveProduct(requestBody);
    }
}
