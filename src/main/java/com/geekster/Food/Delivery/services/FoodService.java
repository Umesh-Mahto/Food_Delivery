package com.geekster.Food.Delivery.services;

import com.geekster.Food.Delivery.models.Foods;
import com.geekster.Food.Delivery.repository.IFoodRepository;
import com.geekster.Food.Delivery.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FoodService {
    @Autowired
    private IFoodRepository iFoodRepository;
    @Autowired
    private IRestaurantRepository iRestaurant;

    public String addFood(Foods food) {
//        Long restaurantId =  food.getFoodsID();
//
//        Restaurant restaurantObj = iRestaurant.findById(restaurantId).get();
//        food.setRestaurant(restaurantObj);
        iFoodRepository.save(food);
        return "Food added Successfully!!";
    }

    public String deleteFood(Long id) {
        iFoodRepository.deleteById(id);
        return "Food deleted Successfully!!";
    }
    @Transactional
    public String updateFoodById(Long id, Double price) {
        iFoodRepository.updateFoodById(id , price);
        return "Food updated Successfully!!";
    }
}
