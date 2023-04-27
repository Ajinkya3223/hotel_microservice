package com.example.hotelservice.Hotel_microservice.service.impl;

import com.example.hotelservice.Hotel_microservice.entities.Hotel;
import com.example.hotelservice.Hotel_microservice.exception.ResourceNotFoundException;
import com.example.hotelservice.Hotel_microservice.repository.HotelRepository;
import com.example.hotelservice.Hotel_microservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
@Autowired
    HotelRepository hotelrepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelrepository.save(hotel);

    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels= hotelrepository.findAll();
        return  hotels;
    }

    @Override
    public Hotel getHotelbyId(String id) {
       Hotel hotel= hotelrepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel not found"));
      return hotel;
    }

    @Override
    public void deleteHotel(String id) {
        hotelrepository.deleteById(id);
    }
}
