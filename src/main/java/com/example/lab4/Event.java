package com.example.lab4;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Event  {
    private UUID id;
    private String name;
    private String type;
    private String details;
    private Date eventDate;

    public Event() {}

    public Event(UUID id, String name, String type, String details, Date eventDate, Integer month, Integer year, Integer weekNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.details = details;
        this.eventDate = eventDate;
    }

    public UUID getId () { return id; }
    public void setId (UUID id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(eventDate);

        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public Integer getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(eventDate);

        return calendar.get(Calendar.MONTH);
    }

    public Integer getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(eventDate);

        return calendar.get(Calendar.YEAR);
    }
    public Integer getWeekNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.setMinimalDaysInFirstWeek(1);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(eventDate);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
