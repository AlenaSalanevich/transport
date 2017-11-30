package com.epam.training.transport.controller.params;

public class RouteParams {
    private int number;
    private String description;

    public RouteParams(final int number) {
        this.number = number;
    }

    public RouteParams(){
    }

    public RouteParams(final int number, final String description){
        this.number=number;
        this.description=description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
