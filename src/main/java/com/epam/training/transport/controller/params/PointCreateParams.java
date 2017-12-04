package com.epam.training.transport.controller.params;

public class PointCreateParams {

    private String name;

    public PointCreateParams() {
    }

    public PointCreateParams(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
