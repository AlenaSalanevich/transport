package com.epam.training.transport.rest.models;

public class RouteCreateParams {

    private String number;

    private String description;

    public RouteCreateParams() {
    }

    public RouteCreateParams(final String number, final String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

}
