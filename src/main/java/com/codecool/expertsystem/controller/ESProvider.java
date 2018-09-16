package com.codecool.expertsystem.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.codecool.expertsystem.model.containers.FactRepository;
import com.codecool.expertsystem.model.containers.Question;
import com.codecool.expertsystem.model.containers.RuleRepository;
import com.codecool.expertsystem.model.parsers.FactParser;
import com.codecool.expertsystem.model.parsers.RuleParser;
import com.codecool.expertsystem.view.View;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userSelection;
    View view;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
        view = new View();
    }

    public void collectAnswers() {
        userSelection = new HashMap<>();
        Iterator<Question> questionIterator = this.ruleRepository.getIterator();
        
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            String questionId = question.getId();

            view.printQuestion(question.getQuestion());
            boolean userAnswer = getAnswerByQuestion(questionId);

            this.userSelection.put(questionId, userAnswer);
        }
    }

    public boolean getAnswerByQuestion(String questionId) {

    }

    public String evaluate() {

    }
    
}