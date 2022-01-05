package com.gmail.grechich.db.enums;

public enum Shop {
    SLC1("СЛЦ№1"),
    SLC2("СЛЦ№2");

    private String shopName;

    Shop(String shopName){
        this.shopName = shopName;
    }

    public String getShopName(){
        return shopName;
    }
}
