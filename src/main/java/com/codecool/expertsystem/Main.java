package com.codecool.expertsystem;

import com.codecool.expertsystem.controller.ESProvider;
import com.codecool.expertsystem.model.parsers.FactParser;
import com.codecool.expertsystem.model.parsers.RuleParser;
import com.codecool.expertsystem.view.View;

public class Main {

    public static void main(String[] args) {
        final String RULESLINK = "/resources/Rules.xml";
        final String FACTSLINK = "/resources/Facts.xml";
        View view = new View();
        ESProvider esProvider = new ESProvider(
            new FactParser(FACTSLINK), new RuleParser(RULESLINK));

        view.printWelcome();
        
    }

}