package com.example.home365_h2db.Configuration;

import com.example.home365_h2db.AirlineUniverse.Destination;
import com.example.home365_h2db.repository.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
public class DestinationConfig {
    @Bean
    CommandLineRunner commandLineRunner(DestinationRepository destinationRepository){
        return args -> {
            Destination telAviv = new Destination("Tel Aviv", 31.988510, 34.857624);
            Destination newYork = new Destination("New York", 40.668973, -73.967414);
            LinkedList<Destination> myDestinations = new LinkedList<>();
            myDestinations.add(telAviv);
            myDestinations.add(newYork);
            destinationRepository.saveAll(myDestinations);

        };
    }

}
