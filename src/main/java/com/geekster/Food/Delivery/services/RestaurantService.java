package com.geekster.Food.Delivery.services;

import com.geekster.Food.Delivery.models.Foods;
import com.geekster.Food.Delivery.models.Restaurant;
import com.geekster.Food.Delivery.repository.IFoodRepository;
import com.geekster.Food.Delivery.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IFoodRepository iFood;

    public String addRestaurant(Restaurant restaurant) {


        List<Foods> foodList =restaurant.getFoods();
        for(Foods foodObj : foodList){
            foodObj.setRestaurant(restaurant);
        }
        iRestaurantRepository.save(restaurant);
        return "Restaurant added Successfully!!";
    }

    public Iterable<Restaurant> getAllRestaurant() {
        return iRestaurantRepository.findAll();
    }
}