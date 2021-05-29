package com.example.home365_h2db.Configuration;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.repository.AircraftRepository;
import com.example.home365_h2db.repository.AirlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AircraftConfiguration {
    @Bean
    CommandLineRunner commandLineRunner2 (AircraftRepository aircraftRepository) {
        return args -> {
            Aircraft air1 = new Aircraft("El-Al", 7.5, 350000, 5600);
            Aircraft air2 = new Aircraft("Turkish-Airlines", 10, 1400000, 12000);
            Aircraft air3 = new Aircraft("Delta", 15, 1500000, 10000);
            Aircraft air4 = new Aircraft("El-Al", 11, 700000, 8500);
            Aircraft air5 = new Aircraft("Air Japan", 9, 560000, 7600);
            Aircraft air6 = new Aircraft("Air Japan", 32, 860000, 9340);
            Aircraft air7 = new Aircraft("Turkish-Airlines", 20, 1000000, 11000);
            Aircraft air8 = new Aircraft("Delta", 14, 1700000, 13500);
            aircraftRepository.save(air1);
            aircraftRepository.save(air2);
            aircraftRepository.save(air3);
            aircraftRepository.save(air4);
            aircraftRepository.save(air5);
            aircraftRepository.save(air6);
            aircraftRepository.save(air7);
            aircraftRepository.save(air8);
        };
    }
}
