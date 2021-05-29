package com.example.home365_h2db;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Destination;
import com.example.home365_h2db.repository.AircraftRepository;
import com.example.home365_h2db.repository.DestinationRepository;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class Home365H2DbApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext configurableApplicationContext =
        SpringApplication.run(Home365H2DbApplication.class, args);
//        DestinationRepository destinationRepository = configurableApplicationContext.getBean(DestinationRepository.class);
//        AircraftRepository aircraftRepository = configurableApplicationContext.getBean(AircraftRepository.class);
//        Aircraft myAircraft = new Aircraft("El-Al",4,50000,500);
//        Aircraft my2ndAircraft = new Aircraft("Turkish-Airlines",14,30000, 380);
//        List<Aircraft> myList = new LinkedList<Aircraft>();
//        myList.add(myAircraft);
//        myList.add(my2ndAircraft);
//        aircraftRepository.saveAll(myList);
//        Destination arizona = new Destination("Arizona", 34.048927, -111.093735);
//        Destination jerusalem = new Destination("Jerusalem", 31.692651, 35.284082);
//        destinationRepository.save(arizona);
//        destinationRepository.save(jerusalem);
    }

}
