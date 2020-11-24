package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ViewEmail {
    private static ViewEmail viewEmail;
    String[] Emails = new String[5];
    int counter = 0;

    public static ViewEmail getViewEmail(){
        if (viewEmail == null){
            viewEmail = new ViewEmail();
        }
        return viewEmail;
    }

    private ViewEmail(){}

    public void viewinfo()throws IOException, SAXException, ParserConfigurationException {
        DefaultHandler handler = new DefaultHandler(){
            boolean name = false;
            @Override
            public void startElement(String uri,String localname, String qName, Attributes attributes){
                if (qName.equalsIgnoreCase("EMAIL")) {
                    name = true;
                }
            }
            @Override
            public  void characters(char[] ch, int start, int length){
                if (name) {
                    System.out.println("Электронная почта: " + new String(ch, start, length));
                    Emails[counter] = new String(ch, start, length);
                    counter++;
                    name = false;
                }
            }
        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("Students.xml"), handler);
    }

    public void whichemail(){
        int yandex = 0, gmail = 0, outlook = 0;
        for(int i = 0; i<5; i++){
            if("outlook".contentEquals(Emails[i].subSequence(5,12))){
                outlook++;
            }
            if("yandex".contentEquals(Emails[i].subSequence(5,11))){
                yandex++;
            }
            if("gmail".contentEquals(Emails[i].subSequence(5,10))){
                gmail++;
            }
        }
        System.out.println("Пользователей почты outlook - "+outlook);
        System.out.println("Пользователей почты yandex - "+yandex);
        System.out.println("Пользователей почты gmail - "+gmail);
    }
}
