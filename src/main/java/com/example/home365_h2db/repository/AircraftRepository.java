package com.example.home365_h2db.repository;

import com.example.home365_h2db.AirlineUniverse.Aircraft;
import com.example.home365_h2db.AirlineUniverse.Airline;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface AircraftRepository extends
        JpaRepository<Aircraft,Long> {
    @Query("SELECT object(a) FROM aircraft a WHERE a.airlineName =?1" )
    List<Aircraft> findByName(String name);
    Aircraft getById(long id);
    Optional<Aircraft> findAircraftById(Long id);
}
