package com.geekster.Food.Delivery.controllers;

import com.geekster.Food.Delivery.models.OrderFood;
import com.geekster.Food.Delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrder")
    public Iterable<OrderFood> getAllOrder(){
        return orderService.getAllOrderdFood();
    }

}
