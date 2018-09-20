package com.codecool.expertsystem.controller;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

import com.codecool.expertsystem.model.containers.FactRepository;
import com.codecool.expertsystem.model.containers.Fact;
import com.codecool.expertsystem.model.containers.Question;
import com.codecool.expertsystem.model.containers.RuleRepository;
import com.codecool.expertsystem.model.parsers.FactParser;
import com.codecool.expertsystem.model.parsers.RuleParser;
import com.codecool.expertsystem.view.View;

public class ESProvider {
    private RuleRepository ruleRepository;
    private FactRepository factRepository;
    private Map<String, Boolean> userSelection;
    private Fact fact;
    View view;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.ruleRepository = ruleParser.getRuleRepository();
        this.factRepository = factParser.getFactRepository();
        view = new View();
    }

    public void collectAnswers() {        
        userSelection = new HashMap<>();
        Iterator<Question> questionIterator = this.ruleRepository.getIterator();
        Scanner scanner = new Scanner(System.in);
        
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            String questionId = question.getId();
            view.printQuestion(question.getQuestion());
            boolean userAnswer = getAnswerByQuestion(question, questionId, scanner);

            this.userSelection.put(questionId, userAnswer);
        }
        scanner.close();
    }

    public boolean getAnswerByQuestion(Question question, String questionId, Scanner scanner) {
        String userInput = getUserInput(scanner);
        return question.getEvaluatedAnswer(userInput);
    }
    
    public String evaluate() {
        String evaluation = "";
        Iterator<Fact> factIterator = this.factRepository.getIterator();

        while (factIterator.hasNext()) {
            this.fact = factIterator.next();
            System.out.println(fact);
            if (!checkMatch(this.fact.getIdSet())) {
                continue;
            }
            evaluation = this.fact.getDescription();
        }
        return evaluation;
    }

    private boolean checkMatch(Set<String> factSet) {     

        for (String id : factSet) {
            System.out.println(id);
            if (this.fact.getValueById(id) == this.userSelection.get(id)) {
                return true;
            }
        }
        return false;
    }

    private String getUserInput(Scanner scanner) {
        String userInput;        
        userInput = scanner.next().toLowerCase();       
        return userInput;
    }

}