package com.epam.training.transport.rest.models;

import java.util.HashMap;

public class RouteHashMapModel {
    private HashMap<String, String> properties;
    
    public RouteHashMapModel() {
        this.properties = new HashMap<>();
    }
    
    public RouteHashMapModel(HashMap<String, String> properties) {
        this.properties = properties;
    }
    
    public HashMap<String, String> getProperties() {
        return properties;
    }
    
    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}