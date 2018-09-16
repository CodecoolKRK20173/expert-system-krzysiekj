package com.codecool.expertsystem.controller;

import com.codecool.expertsystem.model.containers.FactRepository;
import com.codecool.expertsystem.model.containers.RuleRepository;
import com.codecool.expertsystem.model.parsers.FactParser;
import com.codecool.expertsystem.model.parsers.RuleParser;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.ruleRepository = ruleParser.getRulesRepository();
        this.factRepository = factParser.getFactRepository();
    }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {

    }

    public String evaluate() {

    }
    
}