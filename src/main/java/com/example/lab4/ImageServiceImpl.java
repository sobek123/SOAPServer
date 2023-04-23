package com.example.lab4;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.example.lab4.ImageService")
@MTOM
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class ImageServiceImpl implements ImageService {


    public Image downloadImage(String name) throws FileNotFoundException, DocumentException {


        try {
            System.out.println(name);
            return ImageIO.read(new File("C:\\Users\\Maciek\\Desktop\\" + name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageServiceImpl getImageServiceImplPort(MTOMFeature mtomFeature) {
        return null;
    }
}
