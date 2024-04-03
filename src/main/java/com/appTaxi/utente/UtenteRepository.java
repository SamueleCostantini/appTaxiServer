package com.appTaxi.utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
* uso repository ogni volta che devo interagire con le tuple del db
*
* */
@Repository
public interface UtenteRepository
        extends JpaRepository<Utente, Long> {
    //query
    @Query("SELECT u FROM Utente u WHERE u.email= ?1")
    Optional<Utente> findUtenteByEmail(String email);
}
