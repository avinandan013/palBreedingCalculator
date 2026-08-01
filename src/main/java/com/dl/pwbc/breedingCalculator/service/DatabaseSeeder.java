package com.dl.pwbc.breedingCalculator.service;

import com.dl.pwbc.breedingCalculator.Repo.BreedingComboRepository;
import com.dl.pwbc.breedingCalculator.Repo.palFinderRepo;
import com.dl.pwbc.breedingCalculator.entity.BreedingCombo;
import com.dl.pwbc.breedingCalculator.entity.Pal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final palFinderRepo pfRepo;
    private final BreedingComboRepository breedingComboRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getResourceAsStream("/pals.json")) {
            if (inputStream != null) {
                List<Pal> pals = objectMapper.readValue(inputStream, new TypeReference<List<Pal>>(){});
                pfRepo.saveAll(pals);
                System.out.println("Pals saved");
            } else {
                System.out.println("Pals not found");
            }
        }
        try (InputStream inputStream = getClass().getResourceAsStream("/breeding.json")) {
            if (inputStream != null) {
                TypeReference<Map<String, List<List<String>>>> typeRef = new TypeReference<Map<String, List<List<String>>>>() {};

                Map<String, List<List<String>>> breedingData = objectMapper.readValue(inputStream, typeRef);
                List<BreedingCombo> combosToSave = new ArrayList<>();

                //Looping through the JSON key
                for(Map.Entry<String, List<List<String>>> entry : breedingData.entrySet()){
                    String childId = entry.getKey();
                    List<List<String>> parentPairs = entry.getValue();

                    //Looping through every parent pair that creates their offspring
                    for(List<String> parents : parentPairs){
                        if(parents.size() == 2) {
                            BreedingCombo combo = new BreedingCombo();
                            combo.setChildId(childId);
                            combo.setParent1Id(parents.get(0));
                            combo.setParent2Id(parents.get(1));

                            combosToSave.add(combo);
                        }
                    }
                }

                breedingComboRepository.saveAll(combosToSave);
                System.out.println("BreedingCombo saved");
            } else {
                System.out.println("BreedingCombo not found");
            }
        }
    }
}
