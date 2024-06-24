package org.example.pointageEmploye.service;

import org.example.pointageEmploye.model.PublicHoliday;
import org.example.pointageEmploye.repository.CategoryRepository;
import org.example.pointageEmploye.repository.PublicHolidayRepository;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CalendarOfWork {
    private final CalendarHelper calendarHelper;
    private final PublicHolidayRepository publicHolidayRepository;
    private final CategoryRepository categoryRepository;

    public CalendarOfWork(CalendarHelper calendarHelper, PublicHolidayRepository publicHolidayRepository, CategoryRepository categoryRepository) {
        this.calendarHelper = calendarHelper;
        this.publicHolidayRepository = publicHolidayRepository;
        this.categoryRepository = categoryRepository;
    }
    public Map<LocalDateTime , Boolean> getCalendar(){
        Map<LocalDateTime, Boolean> result = new TreeMap<>();
        int maxWorkedHours = getMaxWorkedHours();
        Instant getStartCalendar = getStartCalendar();
        Instant getEndCalendar = getEndCalendar();

        boolean isOpenSunday = maxWorkedHours > 48;
        boolean isOpenSaturday = maxWorkedHours > 40;
        Set<PublicHoliday> closedDates = getCLoseDate(getStartCalendar, getEndCalendar);

        for (; getEndCalendar.compareTo(getStartCalendar) >= 0; getStartCalendar = getStartCalendar.plus(1, ChronoUnit.DAYS)) {
            LocalDate debutDate = getStartCalendar.atZone(ZoneId.systemDefault()).toLocalDate();
            boolean isClosed = closedDates.contains(new PublicHoliday(debutDate));
            if (!isClosed) {
                if (!isOpenSunday && debutDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    continue;
                }
                if (!isOpenSaturday && debutDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    continue;
                }
            }
            result.put(getStartCalendar.atZone(ZoneId.systemDefault()).toLocalDateTime(), !isClosed);
        }

        return result;
    }
    protected Set<PublicHoliday> getCLoseDate(Instant start, Instant end){
        return publicHolidayRepository.getAllCLoseDate(start,end);
    }
    protected Instant getStartCalendar() {
        return calendarHelper.getStart();
    }

    protected Instant getEndCalendar() {
        return calendarHelper.getEnd();
    }

    protected int getMaxWorkedHours() {
        return categoryRepository.getMaxWorkedHours();
    }
}
