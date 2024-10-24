package com.test.service;

import com.test.controller.request.ProductRequestBody;
import com.test.controller.response.ProductResponseBody;

import java.util.List;

public interface ProductService {

    List<ProductResponseBody> findAll();

    void saveProduct(ProductRequestBody productRequestBody);
}
