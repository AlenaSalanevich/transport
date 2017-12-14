package com.epam.training.transport.rest.params;

public class RouteParams {

    private long id;

    private String number;

    private String description;

    public RouteParams() {
    }

    public RouteParams(final long id, final String number, final String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
