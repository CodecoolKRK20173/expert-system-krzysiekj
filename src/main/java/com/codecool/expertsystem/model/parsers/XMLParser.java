package com.codecool.expertsystem.model.parsers;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

abstract class XMLParser {
    protected Document document;

    void loadXmlDocument(String xmlPath) {
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.document = dBuilder.parse(xmlFile);
            this.document.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    Document getDocument() {
        return this.document;
    }

}
