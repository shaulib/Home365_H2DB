package com.example.home365_h2db.Controllers;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Destination;
import com.example.home365_h2db.AirlineUniverse.Distance;
import com.example.home365_h2db.Service.AircraftService;
import com.example.home365_h2db.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/Destinations")
public class DestinationController {
    private final DestinationService destinationService;
    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
        public List<Destination> getDestination(){
            return destinationService.getDestinations();
        }

    @PostMapping("addDestination")
    public void addDestination(@RequestBody Destination destination){
        destinationService.addNewDestination(destination);
        }


    @PostMapping("distancesFromAirline")
    public List<Distance> GetDistances(@RequestParam("Airline") String airline){
       return destinationService.getDistances(airline);
        }
    }

