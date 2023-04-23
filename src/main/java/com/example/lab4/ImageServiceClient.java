package com.example.lab4;

import com.itextpdf.text.DocumentException;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.MTOMFeature;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ImageServiceClient {
    private static final String WS_URL = "https://localhost:8443/lab4_war_exploded/ImageService?wsdl";

    public static void main(String[] args)
            throws IOException, DocumentException {
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Maciek\\Desktop\\lab4\\client_cacerts.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        URL url = new URL(WS_URL);
        QName qname = new QName("http://lab4.example.com/", "ImageServiceImplService");
        HttpsURLConnection.setDefaultHostnameVerifier ((hostname, session) -> true);
        Service service = Service.create(url, qname);
        ImageService port = service.getPort(ImageService.class);
        ImageServiceImpl imageServiceImpl = new ImageServiceImpl();
//        ImageService imageService = imageServiceImpl.getImageServiceImplPort(new MTOMFeature());
//        byte[] image = imageService.downloadImage("Test.jpg");
        Image image = port.downloadImage("Test.jpg");
        JFrame jFrame = new JFrame();
        jFrame.setSize(300,300);
        JLabel jLabel = new JLabel(new ImageIcon(image));
        jFrame.add(jLabel);
        jFrame.setVisible(true);

        System.out.println("imageServer.downlaodImage() : Download Successful");
    }
}
