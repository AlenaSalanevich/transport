package com.epam.training.transport.controller.params;

public class PointCreateParams {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PointCreateParams(String name) {

        this.name = name;
    }
}
