package com.appTaxi.prenotazione;

import com.appTaxi.passeggero.Passeggero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/*
* uso repository ogni volta che devo interagire con le tuple del db
*
* */
@Repository
public interface PrenotazioneRepository
        extends JpaRepository<Prenotazione, Long> {
    //query
    @Query("SELECT p FROM Prenotazione p WHERE p.idPasseggero= ?1")
    List<Prenotazione> findPrenotazioneByIdPasseggero(Long idPasseggero);

    @Query("SELECT p FROM Prenotazione p WHERE p.idTassista= ?1")
    List<Prenotazione> findPrenotazioneByIdTassista(Long idTassista);
}
