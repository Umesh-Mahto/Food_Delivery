package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.models.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderFood,Long> {
}
