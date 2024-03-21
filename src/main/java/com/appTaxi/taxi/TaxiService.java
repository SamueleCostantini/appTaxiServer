package com.appTaxi.taxi;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaxiService {
    public List<Taxi> getTaxi() {
        return List.of(
                new Taxi(
                        1L,
                        "AA111AA"
                )
        );
    }
}
