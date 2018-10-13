package com.jambo.jambo.interfaces.dao;

import com.jambo.jambo.entity.ProductsEntity;

import java.util.List;

public interface ProductsDao {
    void deleteOneProduct(String product);
    void saveOrUpdate(ProductsEntity productsEntity);
    List<ProductsEntity> fetchAllProducts();
    ProductsEntity fetchOneProducts(String product);
    List<ProductsEntity> fetchByPrice(double amount);
}
