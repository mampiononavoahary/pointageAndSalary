package org.example.pointageEmploye.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Employe {
    private String firstName;
    private String lastName;
    private String matricule;
    private Instant birthDate;
    private Instant hireDate;
    private Instant endDate;
    private double grossSalary;
    private Category category;
    private List<Pointing> pointing;

    public Employe(String firstName, String lastName, String matricule, Instant birthDate, Instant hireDate, Instant endDate, double grossSalary, Category category) {
        this.pointing = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.endDate = endDate;
        this.grossSalary = grossSalary;
        this.category = category;
        this.pointing = pointing;
    }

    public double calculateSalaryNet(){
        return this.grossSalary - (this.grossSalary * 0.20);
    }

    public double calculateAdditionalHour(){
        var hour = pointing.stream().mapToDouble(Pointing::getSumHourTravail).sum();
        var res = hour -category.getHeureNormale();
        if (res>20){
            return res;
        }
        return res;
    }
    public void addPointing(Pointing pointing2){
        pointing.add(pointing2);
    }
}

