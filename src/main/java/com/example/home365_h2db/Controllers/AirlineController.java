package com.example.home365_h2db.Controllers;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Airline;
import com.example.home365_h2db.Service.AircraftService;
import com.example.home365_h2db.Service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


    @RestController
    @RequestMapping(path="api/Airlines")
    public class AirlineController {
        private final AirlineService airlineService;

        @Autowired
        public AirlineController(AirlineService airlineService) {
            this.airlineService = airlineService;
        }

        @GetMapping
        public List<Airline> getAirlines(){
            return airlineService.getAirlines();
        }

        @PostMapping("addAirline")
        public void addNewAirline(@RequestBody Airline airline){
            airlineService.addNewAirline(airline);
        }
        @PutMapping("buyAircraft")
        public String buyAircraft(@RequestParam("buyer/seller") List<String> info, @RequestParam("aircraftId") Long id){
           return airlineService.buyAircraft(info,id);
        }

        @GetMapping("availableDestinations")
        public List<String> getAvailableDestinations(@RequestParam("airline") String airlineName)
        {
            return airlineService.getAvailAbleDestinations(airlineName);
        }
    }

