package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ViewName implements View{
    @Override
    public void viewinfo()throws IOException, SAXException, ParserConfigurationException {
            DefaultHandler handler = new DefaultHandler(){
                boolean name = false;
                @Override
                public void startElement(String uri,String localname, String qName, Attributes attributes){
                    if (qName.equalsIgnoreCase("NAME")) {
                        name = true;
                    }
                }
                @Override
                public  void characters(char[] ch, int start, int length){
                    if (name) {
                        System.out.println("Имя: " + new String(ch, start, length));
                        name = false;
                    }
                }
            };
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("Students.xml"), handler);
        }
    }
