package com.dl.pwbc.breedingCalculator.controller;

import com.dl.pwbc.breedingCalculator.controllerImpl.websiteLoaderImpl;
import com.dl.pwbc.breedingCalculator.entity.BreedingCombo;
import com.dl.pwbc.breedingCalculator.service.WhereIsMyChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class websiteLoaderController {

    @Autowired
    websiteLoaderImpl websiteLoaderImpl;
    @Autowired
    WhereIsMyChild whereIsMyChild;

    @GetMapping("/webLoader")
    public ResponseEntity<String> webLoader() {
        websiteLoaderImpl.getMessage();
        return ResponseEntity.ok().body("loaded successfully");
    }

//    <-- example -->
    @GetMapping("/{id}/combos")
    public List<BreedingCombo> getCombos(@PathVariable String id) {
        return whereIsMyChild.getCombosForOffspring(id);
    }
}