package com.example.home365_h2db.Service;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Airline;
import com.example.home365_h2db.repository.AircraftRepository;
import com.example.home365_h2db.repository.AirlineRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {
    private static AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        AircraftService.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAircrafts() {
       return aircraftRepository.findAll();

    }

    public void addNewAircraft(Aircraft aircraft) {
        Optional<Airline> aircraftByAirline  = AirlineService.getAirlineRepository().findByName(aircraft.getAirlineName());
        if (!aircraftByAirline.isPresent()){
            throw new IllegalStateException("Airline wasn't found");
            }
        aircraftRepository.save(aircraft);
        }

    public static List<Aircraft> getAirlinePlanes(String airlineName) {
        return aircraftRepository.findByName(airlineName);
      }

    public static AircraftRepository getAirlineRepository() {
        return aircraftRepository;
    }

    public String sellAircraft(String airlineSeller, Long aircraftId) {
       if(!aircraftRepository.existsById(aircraftId)){
            throw new IllegalStateException("Aircraft wasn't found");
        }
       Aircraft aircraftToSell = aircraftRepository.getById(aircraftId);
       if (!aircraftToSell.getAirlineName().equals(airlineSeller))
           throw new IllegalStateException("Aircraft isn't owned by "+airlineSeller);
        double price = aircraftToSell.getOriginalPrice()*(1-aircraftToSell.getMonthsInuse()*0.02);
        aircraftRepository.deleteById(aircraftId);

        Airline airline = AirlineService.getAirlineRepository().findObjByName(airlineSeller);
        airline.setBalance(airline.getBalance()+price);
        AirlineService.getAirlineRepository().flush();

        return "Aircraft id: "+ aircraftId +" was sold successfully for "+price+" $, "+ airlineSeller+ " balance is: "+ airline.getBalance();


    }
}

