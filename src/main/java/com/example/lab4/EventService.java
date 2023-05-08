package com.example.lab4;

import com.itextpdf.text.DocumentException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebService
public interface EventService {

    @WebMethod
    List<Event> getEventsByDay(int day);
    @WebMethod
    List<Event> getEventsByWeek(Integer weekNumber);
    @WebMethod
    List<Event> getEventsByMonth(Integer monthNumber);

    @WebMethod
    String getDetailsByEvent(Event event) throws Throwable;

    @WebMethod
    Event addEvent(Event event);

    @WebMethod
    void deleteEvent(UUID id) throws Throwable;

    @WebMethod
    Event modifyEvent(UUID id, Event event) throws Throwable;

    @WebMethod
    List<Event> getEvents();

    @WebMethod
    Event getEventById(UUID id) throws Exception;

    @WebMethod
    byte[] downloadFile() throws FileNotFoundException, DocumentException;
}
