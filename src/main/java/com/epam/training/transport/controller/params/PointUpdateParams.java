package com.epam.training.transport.controller.params;

public class PointUpdateParams {
    private String oldName;
    private String newName;

    public PointUpdateParams(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }
    public PointUpdateParams(){

    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
