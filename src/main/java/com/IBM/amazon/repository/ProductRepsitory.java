package com.IBM.amazon.repository;

import com.IBM.amazon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepsitory extends JpaRepository<Product, String> {
}
