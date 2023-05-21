package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.models.Authentication;
import com.geekster.Food.Delivery.models.Costumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepository extends JpaRepository<Authentication , Long> {
    Authentication findByCostumber(Costumber costumberObj);

    Authentication findFirstByAuthenticationToken(String token);
}
