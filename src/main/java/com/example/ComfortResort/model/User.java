package com.example.ComfortResort.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)

    private Integer id;

    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ERole role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Hotel> hotels = new HashSet<Hotel>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Reservation> reservations = new HashSet<Reservation>();


}
