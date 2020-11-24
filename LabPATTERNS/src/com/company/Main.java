package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        ViewFactory viewFactory = createViewByDescription("name");
        View view = viewFactory.createView();
        view.viewinfo();

        ViewEmail.getViewEmail().viewinfo();
        ViewEmail.getViewEmail().whichemail();

        search();

    }

    private static void search() throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("Students.xml");
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        XPathExpression expr = xpath.compile("STUDENTS/PERSON[2]");
        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            System.out.println("Вывод информации об ученике номер 2:" + n.getTextContent());
        }
        System.out.println();
    }


    static ViewFactory createViewByDescription(String description){
        if(description.equalsIgnoreCase("name")){
            return new ViewNameFactory();
        }else if(description.equalsIgnoreCase("surname")){
            return new ViewSurnameFactory();
        }else{
            throw new RuntimeException(description+" is unknown description");
        }
    }
}
