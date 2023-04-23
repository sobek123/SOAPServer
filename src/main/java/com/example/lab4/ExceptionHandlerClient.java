package com.example.lab4;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionHandlerClient {

    private static final String WS_URL = "http://localhost:8080/lab4_war_exploded/ShopInfo?wsdl";

    public static void main(String[] args) throws Exception  {
//        URL url = new URL(WS_URL);
//        QName qname = new QName("http://lab4.example.com/", "ShopInfoImplService");
//
//        Service service = Service.create(url, qname);
////        ShopInfo hello = service.getPort(ShopInfo.class);
//
//        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
//        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
//        Map<String, List<String>> headers = new HashMap<String, List<String>>();
//        headers.put("arg0", Collections.singletonList("szymon"));
//        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
//        String name = "Myszka";
//        try {
////            System.out.println(hello.getShopInfo(name));
//        } catch (WebServiceException | InvalidInputException e) {
//            System.out.println(String.format("Niepoprawna nazwa %s, wprowadz inną.", name));
//        }
//        name = "Szymon";
//        System.out.println("Nowe zapytanie! Nazwa to: " + name );
//        System.out.println(hello.getShopInfo(name));

    }
}
