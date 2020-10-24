package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"login", "firstName", "lastName"})
@Entity
public class User extends BaseEntity {

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @ManyToMany //(fetch = FetchType.EAGER) -- domyślnie jest lazy, czyli wykonuje zapytania na żądanie
    @JoinTable(name = "user_address", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") //tego referenced.. można nie pisać, bo id jest domyślne
    }, inverseJoinColumns = {
            @JoinColumn(name = "address_id", referencedColumnName = "id")
    })
    private Set<Address> addresses;
}
