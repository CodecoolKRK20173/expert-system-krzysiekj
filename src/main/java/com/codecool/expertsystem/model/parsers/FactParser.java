package com.codecool.expertsystem.model.parsers;

import com.codecool.expertsystem.model.containers.FactRepository;

public class FactParser extends XMLParser {
    private FactRepository factRepository;

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);        
        
    }

    public FactRepository getFactRepository() {
        return this.factRepository;
    }

}