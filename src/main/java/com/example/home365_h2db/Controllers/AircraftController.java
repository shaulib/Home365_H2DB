package com.example.home365_h2db.Controllers;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.Service.AircraftService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path="api/Aircrafts")
public class AircraftController {
    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAircrafts(){
        return aircraftService.getAircrafts();
    }

    @PostMapping("/addAircraft")
    public void addAircraft(@RequestBody Aircraft aircraft){
        aircraftService.addNewAircraft(aircraft);
    }

    @GetMapping("getAirline'sAircraft")
    public List<Aircraft> getAirlineAircrafts(@RequestParam(value = "airlineName") String airlineName){
        return AircraftService.getAirlinePlanes(airlineName);
    }

    /**
     * Selling Aircraft for its original price - months of use * 0.02
     * @param airlineSeller Company seller
     * @param aircraftId    Aircraft id
     * @return receipt of transaction
     */
    @DeleteMapping("/{sellAircraft}")
    public String SellAircraft(@RequestParam(name = "airlineSeller") String airlineSeller, @RequestParam(name = "aircraftId") Long aircraftId){
        return aircraftService.sellAircraft(airlineSeller, aircraftId);


    }
}
