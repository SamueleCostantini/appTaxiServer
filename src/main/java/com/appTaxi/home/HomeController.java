package com.appTaxi.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

@RestController
@RequestMapping(path = "home")
public class HomeController {
    public HomeController(){}

    @GetMapping
    public String homePage(){
        /*in questa sezione ci andra il frontend*/

        return "Home page";
    }
}
