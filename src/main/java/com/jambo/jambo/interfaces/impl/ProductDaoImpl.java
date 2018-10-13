package com.jambo.jambo.interfaces.impl;


import com.jambo.jambo.entity.ProductsEntity;
import com.jambo.jambo.interfaces.dao.ProductsDao;
import com.jambo.jambo.interfaces.repo.ProductsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductsDao {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductsRepo productsRepo;

    @Override
    public void deleteOneProduct(String product) {
        try {
            ProductsEntity productsEntity = productsRepo.findByProduct(product);
            productsRepo.delete(productsEntity);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void saveOrUpdate(ProductsEntity productsEntity) {
        try {
            productsRepo.save(productsEntity);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public List<ProductsEntity> fetchAllProducts() {
            return productsRepo.findAll();
    }

    @Override
    public ProductsEntity fetchOneProducts(String product) {
       if(productsRepo.findByProduct(product)!= null){
           return productsRepo.findByProduct(product);
       }
       return productsRepo.findByProduct(product);
    }

    @Override
    public List<ProductsEntity> fetchByPrice(double amount) {
        return productsRepo.findByPrice(amount);
    }
}
