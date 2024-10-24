package com.test.service.impl;

import com.test.controller.request.ProductRequestBody;
import com.test.controller.response.ProductResponseBody;
import com.test.mapper.ProductMapper;
import com.test.repository.ProductRepository;
import com.test.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductMapper mapper;

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void findAll() {
        var product = ProductEntity.builder().build();
        var productResponseBody = new ProductResponseBody();

        when(repository.findAll()).thenReturn(Collections.singletonList(product));
        when(mapper.toResponseBody(any())).thenReturn(productResponseBody);

        var response = productService.findAll();

        assertThat(response).isNotNull();
    }

    @Test
    void saveProduct() {
        var product = ProductEntity.builder().build();
        var request = ProductRequestBody.builder().build();

        when(mapper.toEntity(any())).thenReturn(product);

        productService.saveProduct(request);

        verify(repository).save(product);

    }
}