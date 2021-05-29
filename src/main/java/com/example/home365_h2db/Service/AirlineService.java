package com.example.home365_h2db.Service;
import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Airline;

import com.example.home365_h2db.AirlineUniverse.Destination;
import com.example.home365_h2db.AirlineUniverse.Distance;
import com.example.home365_h2db.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {
    private static AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;

    }

    public static AirlineRepository getAirlineRepository() {
        return airlineRepository;
    }

    public void addNewAirline(Airline airline) {
        Optional<Airline> airlineByName  = airlineRepository.findByName(airline.getName());
        if (airlineByName.isPresent()){
            throw new IllegalStateException("Airline is already in the system");
        }
        airlineRepository.save(airline);
    }

    public List<Airline> getAirlines() {
        return airlineRepository.findAll();
    }

    public String buyAircraft(List<String> info, Long id) {
        String buyer = info.get(0);
        String seller = info.get(1);
        if (!airlineRepository.findByName(buyer).isPresent() || !airlineRepository.findByName(seller).isPresent())
            throw new IllegalStateException("airline buyer or seller wasn't found");
        if (!AircraftService.getAirlineRepository().findAircraftById(id).isPresent())
            throw new IllegalStateException("Aircraft id wasn't found");
        Aircraft a = AircraftService.getAirlineRepository().getById(id);
        double price = a.getOriginalPrice()*(1-a.getMonthsInuse()*0.02);
        Airline buyerAL = airlineRepository.findObjByName(buyer);
        if (buyerAL.getBalance() - price < 0)
            throw new IllegalStateException("buyer airline balance isn't big enough for the purchase");
        Airline sellerAL = airlineRepository.findObjByName(seller);
        buyerAL.setBalance(buyerAL.getBalance()-price);
        sellerAL.setBalance(sellerAL.getBalance()+price);
        a.setAirlineName(buyer);
        airlineRepository.flush();
        AircraftService.getAirlineRepository().flush();

        return "Transaction completed successfully. Aircraft id: "+id+" was Sold to "+ buyer+ " for "+price+ "$";

    }

    public List<String> getAvailAbleDestinations(String airlineName) {
        if (!this.airlineRepository.findByName(airlineName).isPresent())
            throw new IllegalStateException("Airline isn't registered in the system");
        LinkedList<String> availableDestinations = new LinkedList<String>();
        double maxdis = 0;
        for (Aircraft a : AircraftService.getAirlinePlanes(airlineName)) {
            maxdis = Math.max(a.getMaxDistance(),maxdis);
        }
        for (Distance dist : DestinationService.getDistances(airlineName)) {
            if (dist.getDistance() <= maxdis)
                availableDestinations.add(dist.getTo());
        }
        return availableDestinations;
    }
}
