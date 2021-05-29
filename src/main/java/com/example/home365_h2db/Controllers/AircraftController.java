package com.example.home365_h2db.Controllers;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.Service.AircraftService;
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

    @PostMapping("getAirline'sAircraft")
    public List<Aircraft> getAirlinePlanes(@RequestParam(value = "airlineName") String airlineName){
        return aircraftService.getAirlinePlanes(airlineName);
    }

    @DeleteMapping("/{sellAircraft}")
    public String SellAircraft(@RequestParam(name = "airlineSeller") String airlineSeller, @RequestParam(name = "aircraftId") Long aircraftId){
        return aircraftService.sellAircraft(airlineSeller, aircraftId);


    }
}
