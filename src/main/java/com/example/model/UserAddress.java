package com.example.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Entity(name = "userAddress")
public class UserAddress extends BaseEntity {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "zipCode", nullable = false)
    private String zipCode;

    public UserAddress(String city, String country, String street, String zipCode) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.zipCode = zipCode;
    }
}
