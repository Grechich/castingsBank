package com.gmail.grechich.db.enums;

public enum Rail {
    R65("Р65"),
    R50("Р50"),
    R43("Р43"),
    R33("Р33"),
    OTHER("Другой");

    private String railName;

    Rail (String railName){
        this.railName = railName;
    }

    public String getRailName() {
        return railName;
    }
}
