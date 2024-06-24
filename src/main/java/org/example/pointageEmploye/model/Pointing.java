package org.example.pointageEmploye.model;

import lombok.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pointing {
    private Employe employe;
    private LocalTime hourEnter;
    private LocalTime hourSortie;
    private Instant date;

    public Double getSumHourTravail(){
        Duration hours =Duration.between(hourEnter,hourSortie);
        int hoursValue = hours.toHoursPart();
        int minuteHours = hours.toMinutesPart();

        return hoursValue + (minuteHours/60.0);
    }
}
