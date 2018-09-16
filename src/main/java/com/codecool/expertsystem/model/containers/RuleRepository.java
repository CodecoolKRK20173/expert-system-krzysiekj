package com.codecool.expertsystem.model.containers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RuleRepository {
    private Iterator<Question> questionIterator;
    private Map<Question, String> questions;

    public RuleRepository() {
        this.questions = new LinkedHashMap<>();
        this.questionIterator = getIterator();
    }

    public void addQuestion(Question question) {

    }    

    private class QuestionIterator implements Iterator<Question> {

        @Override
        public boolean hasNext() {
    
        }
    
        @Override
        public Fact next() {
    
        }
    
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator();
    }
    
}