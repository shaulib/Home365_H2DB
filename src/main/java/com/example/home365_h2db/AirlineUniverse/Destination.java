package com.example.home365_h2db.AirlineUniverse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Destination {
    @Id
    private String name;
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Destination(String name, double latitude, double longitude) {
        this.name = name;
       this.latitude = latitude;
       this.longitude = longitude;
    }
    public Destination(){}


    public String getName() {
        return name;
    }

}
