package org.example.pointageEmploye.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Category {
    private String nom;
    private Integer heureNormale;
    private Double salaireNormale;
    private Double Indemnite;

    private List<IncreasedHour> increasedHours;
}
