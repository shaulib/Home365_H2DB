package com.example.home365_h2db;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Destination;
import com.example.home365_h2db.repository.AircraftRepository;
import com.example.home365_h2db.repository.DestinationRepository;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class Home365H2DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(Home365H2DbApplication.class, args);
      }

}
