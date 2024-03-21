package com.appTaxi.taxi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *  risorse per api
 * */
@RestController
@RequestMapping(path = "api/v1/taxi")
public class TaxiController {
    private final TaxiService taxiService;

    @Autowired
    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @GetMapping
    public List<Taxi> getTaxi() {
        return taxiService.getTaxi();

    }
}
