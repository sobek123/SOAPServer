package com.example.lab4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventList {

    private List<Event> eventList;

    public EventList() {
        eventList = new ArrayList<>();
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public Event addToEventList(Event event){
        eventList.add(event);
        return event;
    }

    public Event modifyEvent(String name,Event event) throws ArithmeticException, Throwable{
        Event event1 = eventList.stream().filter(el -> el.getName().equals(name)).findFirst().orElseThrow(() -> {
            throw new ArithmeticException();
        });

        event1.setDetails(event.getDetails());
        event1.setMonth(event.getMonth());
        event1.setType(event.getType());
        event1.setWeekNumber(event.getWeekNumber());
        event1.setYear(event.getYear());
        event1.setEventDate(event.getEventDate());

        return event1;
    }


    public List<Event> getEventsByDate(LocalDate localDate) {
        return eventList.stream().filter(el -> el.getEventDate().equals(localDate)).collect(Collectors.toList());
    }


    public List<Event> getEventsByWeek(Integer weekNumber) {
        return eventList.stream().filter(el -> el.getWeekNumber().equals(weekNumber)).collect(Collectors.toList());
    }

    public String getDetailsByEvent(Event event) throws ArithmeticException, Throwable{
        Event event1 = eventList.stream().filter(el -> el == event).findFirst().orElseThrow(() -> {
            throw new ArithmeticException();
        });

        return event1.getDetails();
    }
    

}
