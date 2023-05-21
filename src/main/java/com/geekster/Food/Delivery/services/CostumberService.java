package com.geekster.Food.Delivery.services;

import com.geekster.Food.Delivery.Dto.SignInInput;
import com.geekster.Food.Delivery.Dto.SignInOut;
import com.geekster.Food.Delivery.Dto.SignUpInput;
import com.geekster.Food.Delivery.Dto.SignUpOutput;
import com.geekster.Food.Delivery.models.Authentication;
import com.geekster.Food.Delivery.models.Costumber;
import com.geekster.Food.Delivery.repository.IAuthenticationRepository;
import com.geekster.Food.Delivery.repository.ICostumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CostumberService {
    @Autowired
    ICostumberRepository iCostumberRepository;
    @Autowired
    IAuthenticationRepository iAuthenticationRepository;

    public SignUpOutput signup(SignUpInput signUpInputData) {

        Costumber costumberObj = iCostumberRepository.findFirstByCostumberEmailId(signUpInputData.getUserEmailId());

        if(costumberObj !=null){
            throw new IllegalStateException("Email allready Exist!!");
        }
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signUpInputData.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Costumber costumber = new Costumber(signUpInputData.getUserEmailId() , encryptedPassword , signUpInputData.getUserFirstName() , signUpInputData.getUserLastName() , signUpInputData.getUserAddress() , signUpInputData.getUserMobileNumber());
        iCostumberRepository.save(costumber);

        Authentication authentication = new Authentication(costumber);
        iAuthenticationRepository.save(authentication);
        // iCostumberRepository.save(costumber);
        return new SignUpOutput("SignUp Successfully " ,"Now You can SignIn");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] password = md5.digest();
        String stPassword = new String(password);
        return stPassword;

    }

    public SignInOut signin(SignInInput signInInputData) {
        Costumber costumberObj = iCostumberRepository.findFirstByCostumberEmailId(signInInputData.getUserEmailId());
        if(costumberObj ==null){
            throw new IllegalStateException("Sorry!! Email Not  Found!!");
        }
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signInInputData.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        if(!encryptedPassword.equals(costumberObj.getCostumberPassword())){
            throw new IllegalStateException("Sorry!! Wrong password!!");
        }

        Authentication authenticationObj = iAuthenticationRepository.findByCostumber(costumberObj);

        return new SignInOut("SignIn Successfully!!",authenticationObj.getAuthenticationToken());
    }
}