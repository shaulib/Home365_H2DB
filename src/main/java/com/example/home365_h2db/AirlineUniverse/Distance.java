package com.example.home365_h2db.AirlineUniverse;

import org.springframework.stereotype.Service;

public class Distance {
    private String from;
    private String to;
    private double distance;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }

    public Distance(String from, String to, double distance) {
        this.from = from;
        this.to = to;
       // TODO: 24/05/2021
       this.distance = distance;
    }


}
