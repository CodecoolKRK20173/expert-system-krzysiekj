package com.codecool.expertsystem.model.containers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> answers;

    public Answer() {
        this.answers = new ArrayList<>();
    }

    public void addValue(Value value) {
        this.answers.add(value);        
    }

    public boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        boolean evaluation = false;

        for (Value value : this.answers) {
            if (value.getInputPattern().contains(input)) {
                evaluation = value.getSelectionType();
            } 
        throw new InputMismatchException();

    }   
    
}