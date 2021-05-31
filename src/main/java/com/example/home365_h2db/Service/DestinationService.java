package com.example.home365_h2db.Service;

import com.example.home365_h2db.AirlineUniverse.Airline;
import com.example.home365_h2db.AirlineUniverse.Destination;
import com.example.home365_h2db.AirlineUniverse.Distance;
import com.example.home365_h2db.AirlineUniverse.Haversine;
import com.example.home365_h2db.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private static DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        DestinationService.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestinations() {
        return destinationRepository.findAll();
    }


    public void addNewDestination(Destination destination) {
        Optional<Destination> destinationByName  = destinationRepository.findByName(destination.getName());
        if (destinationByName.isPresent()){
            throw new IllegalStateException("destination is already in the system");
        }
        destinationRepository.save(destination);
    }

    public static List<Distance> getDistances(String airline) {
        if (!AirlineService.getAirlineRepository().findByName(airline).isPresent())
            throw new IllegalStateException("Airline is not registered in the system");
        String desName = (AirlineService.getAirlineRepository().findObjByName(airline).getHomeBase());
        if (!destinationRepository.findByName(desName).isPresent())
            throw new IllegalStateException("HomeBase latitude and longitude of "+airline+" aren't present in the system");
        Destination home = destinationRepository.findObjByName(desName);
        List<Distance> distances = new LinkedList<>();

        for (Destination dest : destinationRepository.findAll()) {
            if (dest.getName().equals(home.getName()))
                continue;
            double distance = Haversine.haversine(home.getLatitude(), home.getLongitude(), dest.getLatitude(), dest.getLongitude());
            distances.add(new Distance(home.getName(), dest.getName(),distance));
        }
        return distances;
    }

}
