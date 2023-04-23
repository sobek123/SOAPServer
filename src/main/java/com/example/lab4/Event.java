package com.example.lab4;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event  {
    private String name;
    private String type;
    private String details;
    private LocalDate eventDate;
    private Integer month;
    private Integer year;
    private Integer weekNumber;

    public Event(String name, String type, String details, LocalDate eventDate, Integer month, Integer year, Integer weekNumber) {
        this.name = name;
        this.type = type;
        this.details = details;
        this.eventDate = eventDate;
        this.month = month;
        this.year = year;
        this.weekNumber = weekNumber;
    }

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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }
}
