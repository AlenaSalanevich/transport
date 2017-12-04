package com.epam.training.transport.controller.params;

public class PointParams {
    private long id;
    private String name;

    public PointParams(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public PointParams() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
