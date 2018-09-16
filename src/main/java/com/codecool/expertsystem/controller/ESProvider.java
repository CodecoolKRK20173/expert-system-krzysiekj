package com.codecool.expertsystem.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

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
            boolean userAnswer = getAnswerByQuestion(question, questionId);

            this.userSelection.put(questionId, userAnswer);
        }
    }

    public boolean getAnswerByQuestion(Question question, String questionId) {
        boolean answer = false;      
        boolean isAnswerCorrect = false;

        while (!isAnswerCorrect) {
            String userInput = getUserInput();
            answer = question.getEvaluatedAnswer(userInput);
            if (answer) {
                isAnswerCorrect = true;
            } else {
                view.enterAnotherAnswer();
            }
        }
        return answer;
    }

    public String evaluate() {

    }

    private String getUserInput() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine().toLowerCase();
        scanner.close();
        return userInput;
    }
    
}