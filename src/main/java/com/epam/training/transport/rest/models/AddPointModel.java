package com.epam.training.transport.rest.models;

public class AddPointModel {

    long pointId;

    int sequence;

    public AddPointModel(long pointId, int sequence) {
        this.pointId = pointId;
        this.sequence = sequence;
    }

    public AddPointModel() {
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public int getSequense() {
        return sequence;
    }

    public void setSequense(int sequense) {
        this.sequence = sequense;
    }

}
