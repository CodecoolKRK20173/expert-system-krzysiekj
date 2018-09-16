package com.codecool.expertsystem.model.containers;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RuleRepository {
    private Iterator<Question> questionIterator;
    private List<Question> questions;

    public RuleRepository() {
        this.questions = new ArrayList<>();
        this.questionIterator = getIterator();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    private class QuestionIterator implements Iterator<Question> {
        int index;

        @Override
        public boolean hasNext() {
            return index < questions.size();
        }
    
        @Override
        public Question next() {
            if (this.hasNext()) {
                return questions.get(index++);
            } else {
                return null;
            }
        }
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator();
    }

}