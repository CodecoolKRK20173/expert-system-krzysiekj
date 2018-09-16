package com.codecool.expertsystem.model.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FactRepository {
    private Iterator<Fact> factIterator;
    private List<Fact> facts;

    public FactRepository() {
        this.facts = new ArrayList<>();
        this.factIterator = new FactIterator();
    }

    public void addFact(Fact fact) {
        this.facts.add(fact);
    }

    private class FactIterator implements Iterator<Fact> {
        int index;

        @Override
        public boolean hasNext() {
            return index < facts.size();
        }
    
        @Override
        public Fact next() {
            if (this.hasNext()) {
                return facts.get(index++);
            } else {
                return null;
            }
        }    
    }

    public Iterator<Fact> getIterator() {
        return  this.factIterator;
    }
}