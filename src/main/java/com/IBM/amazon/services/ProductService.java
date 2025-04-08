package com.IBM.amazon.services;


import com.IBM.amazon.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);
    ProductDto get(String productId);
    ProductDto update(String productId, ProductDto productDto);
    void delete(String productId);
}
