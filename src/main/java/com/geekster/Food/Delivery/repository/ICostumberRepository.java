package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.models.Costumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICostumberRepository extends JpaRepository<Costumber , Long> {

    Costumber findFirstByCostumberEmailId(String userEmailId);
}