package com.jambo.jambo.interfaces.impl;

import com.jambo.jambo.entity.OrderEntity;
import com.jambo.jambo.interfaces.dao.OrderDao;
import com.jambo.jambo.interfaces.repo.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDaoImpl implements OrderDao {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderRepo orderRepo;

    @Override
    public void saveOrUpdate(OrderEntity orderEntity) {
        try {
            orderRepo.save(orderEntity);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }

    }
}
