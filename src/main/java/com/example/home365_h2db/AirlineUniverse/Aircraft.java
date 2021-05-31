package com.example.home365_h2db.AirlineUniverse;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.TrueFalseType;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import java.lang.annotation.Inherited;

@Entity(name = "aircraft")
@Table
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
