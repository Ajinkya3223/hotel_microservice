package com.example.hotelservice.Hotel_microservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Hotel {
    @Id
    private String id;
    @Column(name="hotel_name" ,length=100)
    private  String name;
    @Column(name="loaction_name",length=100)

    private String location;
    @Column(name="about_hotel",length=500)
    private String about;
}
