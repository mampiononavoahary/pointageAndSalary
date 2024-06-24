package org.example.pointageEmploye.service;

import org.example.pointageEmploye.model.Category;
import org.example.pointageEmploye.repository.CategoryRepository;
import org.example.pointageEmploye.repository.PublicHolidayRepository;

public class CalendarOfWorkForCategory extends CalendarOfWork{
    private Category category;
    private final CategoryRepository categoryRepository;

    public CalendarOfWorkForCategory(CalendarHelper calendarHelper, PublicHolidayRepository publicHolidayRepository, CategoryRepository categoryRepository, CategoryRepository categoryRepository1) {
        super(calendarHelper, publicHolidayRepository, categoryRepository);
        this.categoryRepository = categoryRepository1;
    }


    @Override
    protected int getMaxWorkedHours() {
        return categoryRepository.getMaxWorkedHours(category);
    }
}

