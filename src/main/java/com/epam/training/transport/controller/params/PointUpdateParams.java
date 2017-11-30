package com.epam.training.transport.controller.params;

public class PointUpdateParams {
    private String name;
    private String newName;

    public PointUpdateParams(String name, String newName) {
        this.name = name;
        this.newName = newName;
    }
    public PointUpdateParams(){

    }

    public String getName() {
        return name;
    }

      public String getNewName() {
        return newName;
    }

}
