package org.example.pointageEmploye.repository;

import org.example.pointageEmploye.model.Category;

import java.time.Instant;

public interface CategoryRepository {
    Integer getMaxWorkedHours();

    Integer getMaxWorkedHours(Category category);
}
