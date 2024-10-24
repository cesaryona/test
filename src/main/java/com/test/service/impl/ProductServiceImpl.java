package com.test.service.impl;

import com.test.controller.request.ProductRequestBody;
import com.test.controller.response.ProductResponseBody;
import com.test.mapper.ProductMapper;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public List<ProductResponseBody> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseBody)
                .toList();
    }

    @Override
    public void saveProduct(ProductRequestBody productRequestBody) {
        repository.save(mapper.toEntity(productRequestBody));
    }
}
