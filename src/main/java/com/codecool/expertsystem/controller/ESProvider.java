package com.codecool.expertsystem.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.codecool.expertsystem.model.containers.FactRepository;
import com.codecool.expertsystem.model.containers.Question;
import com.codecool.expertsystem.model.containers.RuleRepository;
import com.codecool.expertsystem.model.parsers.FactParser;
import com.codecool.expertsystem.model.parsers.RuleParser;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userSelection;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
    }

    public void collectAnswers() {
        userSelection = new HashMap<>();
        Iterator<Question> questionIterator = this.ruleRepository.getIterator(); 
    }

    public boolean getAnswerByQuestion(String questionId) {

    }

    public String evaluate() {

    }
    
}