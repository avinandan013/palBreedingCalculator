package com.dl.pwbc.breedingCalculator.Repo;

import com.dl.pwbc.breedingCalculator.entity.BreedingCombo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedingComboRepository extends JpaRepository<BreedingCombo, Long> {
    // Spring automatically translates this into:
    // SELECT * FROM BREEDING_COMBOS WHERE CHILD_ID = ?
    List<BreedingCombo> findByChildId(String childId);

    // Find combos where a specific Pal is one of the parents
    List<BreedingCombo> findByParent1IdOrParent2Id(String parent1, String parent2);
}
