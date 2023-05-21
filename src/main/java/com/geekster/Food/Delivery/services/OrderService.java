package com.geekster.Food.Delivery.services;

import com.geekster.Food.Delivery.models.Foods;
import com.geekster.Food.Delivery.models.OrderFood;
import com.geekster.Food.Delivery.models.Restaurant;
import com.geekster.Food.Delivery.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    private IFoodRepository iFoodRepository;
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IAuthenticationRepository authenticationRepo;
    @Autowired
    private ICostumberRepository costumberRepo;
    public String addOrder(OrderFood orderFood) {
        Long foodId = orderFood.getFoods().getFoodsID();
        Long restaurantId = orderFood.getRestaurant().getRestaurantID();
        Foods foodsObj = iFoodRepository.findById(foodId).get();
        Restaurant restuarentObj = iRestaurantRepository.findById(restaurantId).get();

        orderFood.setFoods(foodsObj);
        orderFood.setRestaurant(restuarentObj);

        iOrderRepository.save(orderFood);

        return "Ordered Successfully!!";
    }

    public boolean check(String emailId, String token) {
        if(emailId == null || token == null){
            throw new IllegalStateException("Wrong EmailId And Password!!");
        }
        try {
            String costumberEmail = costumberRepo.findFirstByCostumberEmailId(emailId).getCostumberEmailId();
            String authenticationToken = authenticationRepo.findFirstByAuthenticationToken(token).getAuthenticationToken();

            return costumberEmail.equals(emailId) && authenticationToken.equals((token));
        }catch (Exception e){
            throw new IllegalStateException("Worong EmailId Or Password!!");
        }

    }


    public Iterable<OrderFood> getAllOrderdFood() {
        return iOrderRepository.findAll();
    }
}