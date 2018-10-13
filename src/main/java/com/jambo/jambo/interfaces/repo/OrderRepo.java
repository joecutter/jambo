package com.jambo.jambo.interfaces.repo;

import com.jambo.jambo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
}
