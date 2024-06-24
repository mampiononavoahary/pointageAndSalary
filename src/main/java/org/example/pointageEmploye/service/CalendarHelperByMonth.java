package org.example.pointageEmploye.service;

import java.time.*;

public class CalendarHelperByMonth implements CalendarHelper{
    private final Month month;

    public CalendarHelperByMonth(Month month) {
        this.month = month;
    }


    @Override
    public Instant getStart() {
        LocalDate today = LocalDate.now();
        LocalDateTime result = LocalDateTime.of(today.getYear(), month.getValue(), 1, 8, 0);
        return result.atZone(ZoneId.systemDefault()).toInstant();
    }

    @Override
    public Instant getEnd() {
        LocalDate today = LocalDate.now();
        LocalDateTime result = LocalDateTime.of(today.getYear(), month.getValue(), month.minLength(), 16, 0);
        return result.atZone(ZoneId.systemDefault()).toInstant();
    }
}

