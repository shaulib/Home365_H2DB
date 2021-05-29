package com.example.home365_h2db.Configuration;

import com.example.home365_h2db.AirlineUniverse.Airline;
import com.example.home365_h2db.repository.AirlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirlineConfiguration {
    @Bean
    CommandLineRunner commandLineRunner1 (AirlineRepository airlineRepository){
        return args -> {
            Airline El_Al = new Airline("El-Al", 90000, "Tel Aviv");
            Airline TurkishAirlines = new Airline("Turkish-Airlines", 2800000, "Anatalia");
            airlineRepository.save(El_Al);
            airlineRepository.save(TurkishAirlines);
        };
    }
}
