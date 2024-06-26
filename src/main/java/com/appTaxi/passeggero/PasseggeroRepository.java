package com.appTaxi.passeggero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
* uso repository ogni volta che devo interagire con le tuple del db
*
* */
@Repository
public interface PasseggeroRepository
        extends JpaRepository<Passeggero, Long> {
    //query
    @Query("SELECT u FROM Passeggero u WHERE u.email= ?1")
    Optional<Passeggero> findPasseggeroByEmail(String email);
}
