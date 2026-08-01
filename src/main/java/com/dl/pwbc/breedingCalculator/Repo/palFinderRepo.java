package com.dl.pwbc.breedingCalculator.Repo;

import com.dl.pwbc.breedingCalculator.entity.Pal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface palFinderRepo extends JpaRepository<Pal,Integer> {
    public Pal findById(int id);
}