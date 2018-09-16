package com.codecool.expertsystem.model.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FactRepository {
    private Iterator<Fact> factIterator;
    private List<Fact> facts;

    public FactRepository() {
        this.facts = new ArrayList<>();
        this.factIterator = getIterator();
    }

    public void addFact(Fact fact) {

    }

    private class FactIterator implements Iterator<Fact> {

        @Override
        public boolean hasNext() {
    
        }
    
        @Override
        public Fact next() {
    
        }
    
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator();
    }
}