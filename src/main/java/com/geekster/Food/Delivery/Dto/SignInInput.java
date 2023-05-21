package com.geekster.Food.Delivery.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInInput {
    private String userEmailId;
    private String password;

}