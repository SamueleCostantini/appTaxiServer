package com.appTaxi.tassista;

import com.appTaxi.tassista.Tassista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
* uso repository ogni volta che devo interagire con le tuple del db
*
* */
@Repository
public interface TassistaRepository
        extends JpaRepository<com.appTaxi.tassista.Tassista, Long> {
    //query
    @Query("SELECT u FROM Tassista u WHERE u.email= ?1")
    Optional<com.appTaxi.tassista.Tassista> findTassistaByEmail(String email);
}
