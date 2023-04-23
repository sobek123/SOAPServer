package com.example.lab4;

import com.itextpdf.text.DocumentException;

import javax.jws.WebService;
import java.awt.*;
import java.io.FileNotFoundException;

@WebService
public interface ImageService {
    Image downloadImage(String name) throws FileNotFoundException, DocumentException;

}
