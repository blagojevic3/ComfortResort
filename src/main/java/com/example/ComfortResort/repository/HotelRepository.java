package com.example.ComfortResort.repository;

import com.example.ComfortResort.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
