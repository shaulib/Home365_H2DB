package com.example.home365_h2db.AirlineUniverse;

import javax.persistence.*;

@Entity(name = "aircraft")
@Table
public class Aircraft {
    @Id
    @GeneratedValue
    private Long id;
    private String airlineName;
    private double monthsInuse;
    private double originalPrice;
    private int maxDistance;


    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Aircraft(String airlineName, double monthsInuse, double originalPrice, int maxDistance) {
        this.airlineName = airlineName;
        this.monthsInuse = monthsInuse;
        this.originalPrice = originalPrice;
        this.maxDistance = maxDistance;

    }
    public Aircraft(Long id, String airlineName, double monthsInuse, double originalPrice, int maxDistance) {
        this.id = id;
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

    public int getMaxDistance() {
        return maxDistance;
    }
}
