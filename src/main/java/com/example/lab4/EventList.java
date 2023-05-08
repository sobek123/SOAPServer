package com.example.lab4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventList {

    private List<Event> eventList;

    public EventList() {
        eventList = new ArrayList<>();
        eventList.add(new Event(UUID.randomUUID(), "Default Name", "Default Type", "Default Details", new Date(), 1, 2023, 1));
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public Event addToEventList(Event event){
        if(event.getId() == null) {
            event.setId(UUID.randomUUID());
        }

        eventList.add(event);
        return event;
    }

    public Event modifyEvent(UUID id, Event event) throws ArithmeticException, Throwable{
        Event event1 = eventList.stream().filter(el -> el.getId().equals(id)).findFirst().orElseThrow(() -> {
            throw new ArithmeticException();
        });

        event1.setName(event.getName());
        event1.setDetails(event.getDetails());
        event1.setType(event.getType());
        event1.setEventDate(event.getEventDate());

        return event1;
    }

    public void deleteEvent(UUID id) throws ArithmeticException, Throwable {
        Event event1 = eventList.stream().filter(el -> el.getId().equals(id)).findFirst().orElseThrow(() -> {
            throw new ArithmeticException();
        });

        eventList.remove(event1);
    }

    public Event getEventById(UUID id) throws Exception {
        return eventList.stream().filter(el -> el.getId().equals(id)).findFirst().orElseThrow(Exception::new);
    }

    public List<Event> getEventsByDay(int day) {
        return eventList.stream().filter(el -> el.getDay().equals(day)).collect(Collectors.toList());
    }


    public List<Event> getEventsByWeek(Integer weekNumber) {
        return eventList.stream().filter(el -> el.getWeekNumber().equals(weekNumber)).collect(Collectors.toList());
    }

    public List<Event> getEventsByMonth(Integer monthNumber) {
        return eventList.stream().filter(el -> el.getMonth().equals(monthNumber)).collect(Collectors.toList());
    }

    public String getDetailsByEvent(Event event) throws ArithmeticException, Throwable{
        Event event1 = eventList.stream().filter(el -> el == event).findFirst().orElseThrow(() -> {
            throw new ArithmeticException();
        });

        return event1.getDetails();
    }
}
