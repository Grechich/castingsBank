package com.gmail.grechich.db.enums;

public enum SteelGrade {
    STEEL20L("20Л"),
    STEEL25L("25Л"),
    STEEL30L("30Л"),
    STEEL35L("35Л"),
    STEEL40L("40Л"),
    STEEL110G13L("110Г13Л"),
    STEEL("Другая");

    private String steelGrate;

    SteelGrade(String steelGrate){
        this.steelGrate = steelGrate;
    }

    public String getSteelGrate() {
        return steelGrate;
    }
}
