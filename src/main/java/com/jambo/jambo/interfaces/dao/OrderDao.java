package com.jambo.jambo.interfaces.dao;

import com.jambo.jambo.entity.OrderEntity;

public interface OrderDao {
    void saveOrUpdate(OrderEntity orderEntity);
}
