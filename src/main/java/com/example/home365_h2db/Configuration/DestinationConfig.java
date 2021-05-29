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
            Destination rioDeJaneiro = new Destination("Rio de janeiro",-21.125500,-55.270597);
            Destination cusco = new Destination("Cusco", -13.581920,-71.953287);
            Destination ushuaia = new Destination("Ushuaia",-54.836133,-68.280973);
            Destination london = new Destination("London",51.179340,0.075241);
            Destination capeTown = new Destination("Cape Town",-34.169091,18.486279);
            Destination tokyo = new Destination("Tokyo",35.683179,139.721540);
            Destination anatalya = new Destination("Anatalya", 36.905980,30.653486);
            Destination telAviv = new Destination("Tel Aviv", 31.988510, 34.857624);
            Destination newYork = new Destination("New York", 40.668973, -73.967414);
            LinkedList<Destination> myDestinations = new LinkedList<>();
            myDestinations.add(telAviv);
            myDestinations.add(newYork);
            myDestinations.add(tokyo);
            myDestinations.add(capeTown);
            myDestinations.add(london);
            myDestinations.add(ushuaia);
            myDestinations.add(cusco);
            myDestinations.add(rioDeJaneiro);
            myDestinations.add(anatalya);
            destinationRepository.saveAll(myDestinations);

        };
    }

}
