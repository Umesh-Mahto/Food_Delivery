package com.geekster.Food.Delivery.controllers;

import com.geekster.Food.Delivery.Dto.SignInInput;
import com.geekster.Food.Delivery.Dto.SignInOut;
import com.geekster.Food.Delivery.Dto.SignUpInput;
import com.geekster.Food.Delivery.Dto.SignUpOutput;
import com.geekster.Food.Delivery.services.CostumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    CostumberService costumberService;
    //SignUp user:
    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpInputData){
        return costumberService.signup(signUpInputData);
    }
    //SignIn user:
    @PostMapping("/signin")
    public SignInOut signin(@RequestBody SignInInput signInInputData){
        return costumberService.signin(signInInputData);
    }

}