package com.example.lab4;

import com.itextpdf.text.DocumentException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.awt.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

@WebService
public interface EventService {

    @WebMethod
    List<Event> getEventsByDate(LocalDate localDate);

    @WebMethod
    List<Event> getEventsByWeek(Integer weekNumber);

    @WebMethod
    String getDetailsByEvent(Event event) throws Throwable;

    @WebMethod
    Event addEvent(Event event);

    @WebMethod
    Event modifyEvent(String name,Event event) throws Throwable;

    @WebMethod
    List<Event> getEvents();

    @WebMethod
    Image downloadFile() throws FileNotFoundException, DocumentException;
}
