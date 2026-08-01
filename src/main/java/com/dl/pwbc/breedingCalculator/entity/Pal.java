package com.dl.pwbc.breedingCalculator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PALS")
public class Pal {

    @Id
    @JsonProperty("key")
    private String palId;

    @JsonProperty("name")
    private String palName;

    private String palElement;

    @JsonProperty("types")
    public void unpackElementFromNestedObject(List<Map<String, String>> types) {
        if (types != null && !types.isEmpty()) {
            // Grabs the "name" value from the first item in the array
            this.palElement = types.get(0).get("name");
        }
    }

}
