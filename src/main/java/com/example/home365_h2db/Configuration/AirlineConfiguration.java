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
            Airline El_Al = new Airline("El-Al", 2200000, "Tel Aviv");
            Airline TurkishAirlines = new Airline("Turkish-Airlines", 2800000, "Anatalya");
            Airline deltaAirLines = new Airline("Delta",4800000,"New York");
            Airline airJapan = new Airline("Air Japan", 3800000,"Tokyo");
            airlineRepository.save(El_Al);
            airlineRepository.save(TurkishAirlines);
            airlineRepository.save(deltaAirLines);
            airlineRepository.save(airJapan);
        };
    }
}
