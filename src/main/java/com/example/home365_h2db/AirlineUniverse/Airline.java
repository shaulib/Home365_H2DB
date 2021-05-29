package com.example.home365_h2db.AirlineUniverse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Entity
@Table
public class Airline {
    @Id
    private String name;
    private double balance;
    private String homeBase;
//

    public Airline() {
    }

    public Airline(String name, double balance, String homeBaseName) {
        this.name = name;
        this.balance = balance;
        this.homeBase = homeBaseName;
//
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getHomeBase() {
        return homeBase;
    }

    public Aircraft buyAircraft(Airline airLine, Long AircraftId) {
        return null;
    }



//    public void addAircraft(Aircraft aircraft) {
//        this.aircrasts.add(aircraft);
//    }
}
