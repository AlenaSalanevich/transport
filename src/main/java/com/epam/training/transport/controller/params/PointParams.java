package com.epam.training.transport.controller.params;

public class PointParams {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PointParams(String name) {

        this.name = name;
    }
    public PointParams(){

    }
}
