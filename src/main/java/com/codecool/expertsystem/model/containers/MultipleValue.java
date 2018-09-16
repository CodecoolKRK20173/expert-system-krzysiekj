package com.codecool.expertsystem.model.containers;

import java.util.List;

public class MultipleValue extends Value {

    public MultipleValue(List<String> params, boolean selectionType) {
        this.inputPattern = params;
        this.selectionType = selectionType;
    }
}