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
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "bed_count", nullable = false)
    private Integer bedCount;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "price", nullable = false)
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
    private Set<Reservation> reservations = new HashSet<Reservation>();

}
