package com.example.home365_h2db.repository;

import com.example.home365_h2db.AirlineUniverse.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.crypto.Des;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {

    Optional<Destination> findByName(String name);
    @Query("SELECT object(d) FROM Destination d where d.name =?1")
    Destination findObjByName(String name);
}
