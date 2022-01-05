package com.gmail.grechich.db.enums;

public enum CastingType {
    FROG("Крестовина"),
    CORE("Сердечник"),
    MONOBLOCK("Моноблок"),
    HULL("Корпус"),
    CLEAT("Клемма"),
    PAD("Подкладка"),
    INSERT("Вкладыш"),
    PLATE("Плита"),
    OTHER("Другая");

    private String type;

    CastingType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
