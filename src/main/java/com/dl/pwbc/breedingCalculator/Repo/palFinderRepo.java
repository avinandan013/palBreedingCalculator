package com.dl.pwbc.breedingCalculator.Repo;

import com.dl.pwbc.breedingCalculator.entity.BreedingCombo;
import com.dl.pwbc.breedingCalculator.entity.Pal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface palFinderRepo extends JpaRepository<Pal,String>{
}