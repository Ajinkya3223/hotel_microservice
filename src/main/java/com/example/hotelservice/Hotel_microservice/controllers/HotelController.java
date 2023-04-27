package com.example.hotelservice.Hotel_microservice.controllers;

import com.example.hotelservice.Hotel_microservice.entities.Hotel;
import com.example.hotelservice.Hotel_microservice.exception.ApiResponseMessage;
import com.example.hotelservice.Hotel_microservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelservice;
    @GetMapping("/allhotels")
    public ResponseEntity<List<Hotel>> getALLHotels(){
          List<Hotel> hotels=hotelservice.getAll();
        return  new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping("/storehotel")
    public ResponseEntity<Hotel> storeHotel(@RequestBody Hotel hotel){
        Hotel hotel1=hotelservice.createHotel(hotel);
        return new ResponseEntity<>(hotel1,HttpStatus.CREATED);
    }
    @DeleteMapping("/deletehotel/{hotelid}")
   public ResponseEntity<ApiResponseMessage> deleteHotel(@PathVariable String hotelid){
       hotelservice.deleteHotel(hotelid);
        ApiResponseMessage message= ApiResponseMessage.builder().message("Hotel deleted").status(HttpStatus.OK).success(true).build();
        return  new ResponseEntity<>(message,HttpStatus.OK);
    }
    @GetMapping("gethotel/{hotelid}")
    public ResponseEntity<Hotel> gethotelbyId(@PathVariable String hotelid){
        Hotel hotel=hotelservice.getHotelbyId(hotelid);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
}
