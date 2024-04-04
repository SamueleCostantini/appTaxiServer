package com.appTaxi.taxi;

import com.appTaxi.taxi.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
* uso repository ogni volta che devo interagire con le tuple del db
*
* */
@Repository
public interface TaxiRepository
        extends JpaRepository<Taxi, Long> {
    //query
    @Query("SELECT u FROM Taxi u WHERE u.targa= ?1")
    Optional<Taxi> findTaxiByTarga(String email);
}
