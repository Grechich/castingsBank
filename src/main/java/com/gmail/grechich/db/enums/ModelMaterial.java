package com.gmail.grechich.db.enums;

public enum ModelMaterial {
    STEEL("Сталь"),
    AL("Алюминий"),
    PLASTIC("Пластик"),
    WOOD("Дерево"),
    OTHER("Другой");

    private String material;

    ModelMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
