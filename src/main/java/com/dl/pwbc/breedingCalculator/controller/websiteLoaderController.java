package com.dl.pwbc.breedingCalculator.controller;

import com.dl.pwbc.breedingCalculator.controllerImpl.websiteLoaderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class websiteLoaderController {

    @Autowired
    websiteLoaderImpl websiteLoaderImpl;
    @GetMapping("/webLoader")
    public ResponseEntity<String> webLoader(){
        websiteLoaderImpl.getMessage();
        return ResponseEntity.ok().body("loaded successfully");
    }
}
