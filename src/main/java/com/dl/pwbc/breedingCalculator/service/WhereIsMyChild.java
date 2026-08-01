package com.dl.pwbc.breedingCalculator.service;

import com.dl.pwbc.breedingCalculator.Repo.palFinderRepo;
import com.dl.pwbc.breedingCalculator.entity.Pal;
import org.springframework.beans.factory.annotation.Autowired;

public class WhereIsMyChild {

    @Autowired
    palFinderRepo pfRepo;
    public Pal findMyChild(Pal parentA, Pal parentB){
        int avg = (parentA.getPalId()+parentB.getPalId()) / 2;
        Pal child = pfRepo.findById(avg);
        return child;
    }
}
