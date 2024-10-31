package com.example.ComfortResort.repository;

import com.example.ComfortResort.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
