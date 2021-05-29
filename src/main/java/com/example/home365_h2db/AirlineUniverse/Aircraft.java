package com.example.home365_h2db.AirlineUniverse;

import javax.persistence.*;

@Entity(name = "aircraft")
@Table
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airlineName;
    private double monthsInuse;
    private double originalPrice;
    private double maxDistance;


    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Aircraft(String airlineName, double monthsInuse, double originalPrice, double maxDistance) {
        this.airlineName = airlineName;
        this.monthsInuse = monthsInuse;
        this.originalPrice = originalPrice;
        this.maxDistance = maxDistance;

    }


    public Aircraft() {
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setMonthsInuse(double monthsInuse) {
        this.monthsInuse = monthsInuse;
    }

    public Long getId(){return this.id;}
    public double getMonthsInuse() {
        return monthsInuse;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getMaxDistance() {
        return maxDistance;
    }
}
