package com.dl.pwbc.breedingCalculator.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BREEDING_COMBOS")
public class BreedingCombo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String childId;
    private String parent1Id;
    private String parent2Id;

}
