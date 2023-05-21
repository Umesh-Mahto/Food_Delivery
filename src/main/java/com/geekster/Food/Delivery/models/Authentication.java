package com.geekster.Food.Delivery.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authenticationId;
    private String authenticationToken;
    private LocalDate localDate;
    @OneToOne
    @JoinColumn(nullable = false , name = "foreign_key")
    private Costumber costumber;

    public Authentication(Costumber costumber) {
        this.costumber = costumber;
        this.localDate=LocalDate.now();
        this.authenticationToken= UUID.randomUUID().toString();

    }
}