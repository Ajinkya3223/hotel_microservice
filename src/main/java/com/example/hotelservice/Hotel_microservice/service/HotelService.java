package com.example.hotelservice.Hotel_microservice.service;

import com.example.hotelservice.Hotel_microservice.entities.Hotel;

import java.util.List;

public interface HotelService
{
    Hotel createHotel(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotelbyId(String id);

    void deleteHotel(String id);

}
