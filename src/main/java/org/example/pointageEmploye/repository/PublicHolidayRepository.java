package org.example.pointageEmploye.repository;

import org.example.pointageEmploye.model.PublicHoliday;

import java.time.Instant;
import java.util.Set;

public interface PublicHolidayRepository {
    Set<PublicHoliday> getAllCLoseDate(Instant start, Instant end);
}
