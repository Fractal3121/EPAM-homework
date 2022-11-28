package com.epam.rd.java.basic.task8.models;

import java.util.List;

public class Flowers {

    private List<Flower> flowerList;

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public Flowers(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }
}
