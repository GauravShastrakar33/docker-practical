package com.IBM.amazon.services.impl;

import com.IBM.amazon.dto.ProductDto;
import com.IBM.amazon.entity.Product;
import com.IBM.amazon.exceptions.ResourceNotFoundException;
import com.IBM.amazon.repository.ProductRepsitory;
import com.IBM.amazon.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepsitory productRepsitory;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        String productId = UUID.randomUUID().toString();
        product.setProductId(productId);
        Product savedProduct = productRepsitory.save(product);
        return mapper.map(savedProduct,ProductDto.class);
    }

    @Override
    public ProductDto get(String productId) {
        Product product = productRepsitory.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product with given id not found"));
        return mapper.map(product,ProductDto.class);
    }

    @Override
    public ProductDto update(String productId, ProductDto productDto) {
        Product product = productRepsitory.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setQuantity(productDto.getQuantity());
        Product savedProduct = productRepsitory.save(product);
        return mapper.map(savedProduct,ProductDto.class);
    }

    @Override
    public void delete(String productId) {
        Product product = productRepsitory.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        productRepsitory.delete(product);
    }
}
