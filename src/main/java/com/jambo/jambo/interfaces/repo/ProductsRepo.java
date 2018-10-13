package com.jambo.jambo.interfaces.repo;

import com.jambo.jambo.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepo extends JpaRepository<ProductsEntity,Integer> {
    List<ProductsEntity> findAll();
    ProductsEntity findByProduct(String name);
    List<ProductsEntity> findByPrice(double amount);

}
