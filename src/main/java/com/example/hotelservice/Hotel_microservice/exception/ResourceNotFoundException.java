package com.example.hotelservice.Hotel_microservice.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
