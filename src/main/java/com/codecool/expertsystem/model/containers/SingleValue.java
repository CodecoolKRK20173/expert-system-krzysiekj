package com.codecool.expertsystem.model.containers;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleValue extends Value {

    public SingleValue(String param, boolean selectionType) {
        this.inputPattern = new ArrayList<>();
        inputPattern.add(param);
        this.selectionType = selectionType;
    }

}