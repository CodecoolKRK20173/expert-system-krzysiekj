package com.codecool.expertsystem.view;

public class View {

    public void printWelcome() {
        System.out.println("Welcome to Mountain Hiking Advisor!\n"
                + "You want to hike near Cracow?\n"
                + "Ok, let me ask you some questions");
    }

    public void printResult(String result) {
        System.out.println("If I can suggest i'd make this trail: " + result);
    }

}