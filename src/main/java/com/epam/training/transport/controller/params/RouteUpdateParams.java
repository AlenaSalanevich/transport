package com.epam.training.transport.controller.params;

public class RouteUpdateParams {

    private int number;
    private int newNumber;

    public RouteUpdateParams(int number, int newNumber) {
        this.number = number;
        this.newNumber = newNumber;
    }

    public RouteUpdateParams() {
    }

    public int getNumber() {
        return number;
    }

    public int getNewNumber() {
        return newNumber;
    }
}
