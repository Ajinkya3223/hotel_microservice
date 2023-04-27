package com.example.hotelservice.Hotel_microservice.repository;

import com.example.hotelservice.Hotel_microservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {
}
