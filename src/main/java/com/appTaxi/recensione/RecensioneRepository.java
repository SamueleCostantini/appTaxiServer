package com.appTaxi.recensione;

import com.appTaxi.recensione.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
* uso repository ogni volta che devo interagire con le tuple del db
*
* */
@Repository
public interface RecensioneRepository
        extends JpaRepository<Recensione, Long> {
    //query
    @Query("SELECT u FROM Recensione u WHERE u.targa= ?1")
    Optional<Recensione> findRecensioneByTarga(String email);
}
