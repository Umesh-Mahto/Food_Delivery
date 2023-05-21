package com.geekster.Food.Delivery.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Costumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumberId;
    private String costumberEmailId;
    private String costumberPassword;
    private  String costumberFirstName;
    private String costumberLastName;
    private String costumberAddress;
    private  String costumberMobileNumber;

    public Costumber(String costumberEmailId, String costumberPassword, String costumberFirstName, String costumberLastName, String costumberAddress, String costumberMobileNumber) {
        this.costumberEmailId = costumberEmailId;
        this.costumberPassword = costumberPassword;
        this.costumberFirstName = costumberFirstName;
        this.costumberLastName = costumberLastName;
        this.costumberAddress = costumberAddress;
        this.costumberMobileNumber = costumberMobileNumber;
    }
}
