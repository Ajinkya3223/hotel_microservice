package com.example.hotelservice.Hotel_microservice.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<Map<String, Object>> resourcenotfoundexceptionhandler(ResourceNotFoundException ex){
//     ApiResponseMessage message=ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
//      return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    Map map=new HashMap<>();
    map.put("message",ex.getMessage());
    map.put("success",false);
    map.put("status",HttpStatus.NOT_FOUND);
      return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <Map<String,String>> methodargumentnotvalidexceptionhandler(MethodArgumentNotValidException ex){
     Map<String,String> map=new HashMap<>();
     ex.getBindingResult().getFieldErrors().forEach(error->
             map.put(error.getField() , error.getDefaultMessage()  )
     );
        return new ResponseEntity<Map<String, String>>(map,HttpStatus.BAD_REQUEST);
    }

}
