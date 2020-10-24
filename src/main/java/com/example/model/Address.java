package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends BaseEntity {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "street", nullable = false)
    private String street;

    @ManyToMany(mappedBy = "addresses")
    private Set<User> users;
}
