package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface View {
    void viewinfo() throws IOException, SAXException, ParserConfigurationException;
}
