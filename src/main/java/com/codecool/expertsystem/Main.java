package com.codecool.expertsystem;

import com.codecool.expertsystem.controller.ESProvider;
import com.codecool.expertsystem.model.parsers.FactParser;
import com.codecool.expertsystem.model.parsers.RuleParser;
import com.codecool.expertsystem.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        ESProvider esProvider = new ESProvider(FactParser, RuleParser);

        
        
    }

}