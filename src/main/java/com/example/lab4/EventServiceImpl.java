package com.example.lab4;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import java.awt.Image;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebService(endpointInterface = "com.example.lab4.EventService")
@MTOM
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class EventServiceImpl implements EventService {
    EventList eventList = new EventList();
    @Override
    public List<Event> getEventsByDay(int day) {
        return eventList.getEventsByDay(day);
    }

    @Override
    public List<Event> getEventsByWeek(Integer weekNumber) {
        return eventList.getEventsByWeek(weekNumber);
    }

    @Override
    public List<Event> getEventsByMonth(Integer monthNumber) {
        return eventList.getEventsByMonth(monthNumber);
    }

    @Override
    public String getDetailsByEvent(Event event) throws Throwable {
        return eventList.getDetailsByEvent(event);
    }

    @Override
    public Event addEvent(Event event) {
       return eventList.addToEventList(event);
    }

    @Override
    public Event modifyEvent(String name,Event event) throws Throwable{
        return eventList.modifyEvent(name,event);
    }

    @Override
    public List<Event> getEvents() {
        return eventList.getEventList();
    }

    @Override
    public Event getEventById(UUID id) throws Exception {
        return eventList.getEventById(id);
    }

    @Override
    public byte[] downloadFile() throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);

        document.open();

        PdfPTable table = new PdfPTable(5);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("Nazwa wydarzenia");
        list.add("Data wydarzenia");
        list.add("Rodzaj wydarzenia");
        list.add("Opis wydarzenia");
        list.forEach(el -> {
            PdfPCell pdfPCell = new PdfPCell();
            pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pdfPCell.setPhrase(new Phrase(el));
            pdfPCell.setBorderWidth(2);
            table.addCell(pdfPCell);
        });

        EventList eventList = new EventList();
        List<Event> eventList1 = eventList.getEventList();
        int j = 1;
        for(Event event: eventList1){
            table.addCell(String.valueOf(j));
            table.addCell(event.getName());
            table.addCell(event.getEventDate().toString());
            table.addCell(event.getType());
            table.addCell(event.getDetails());
            j++;
        }
        Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC, 20, BaseColor.BLACK);
        Chunk chunk = new Chunk("Zestawienie wydarzen\n", font);
        Paragraph paragraph = new Paragraph(chunk);
        paragraph.setSpacingAfter(50f);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        document.add(paragraph);
        document.add(table);
        document.close();

        return out.toByteArray();
    }

}
