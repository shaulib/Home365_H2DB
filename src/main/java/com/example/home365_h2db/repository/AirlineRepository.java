package com.example.home365_h2db.repository;

import com.example.home365_h2db.AirlineUniverse.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AirlineRepository extends
        JpaRepository <Airline,String> {
    Optional<Airline> findByName(String name);
    @Query("SELECT OBJECT(a) FROM Airline a WHERE a.name=?1")
    Airline findObjByName(String name);
}


