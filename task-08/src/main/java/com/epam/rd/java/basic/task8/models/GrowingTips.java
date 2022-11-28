package com.epam.rd.java.basic.task8.models;

public class GrowingTips {
    private Integer tempreture;
    private String lighting;
    private Integer watering;

    public Integer getTempreture() {
        return tempreture;
    }

    public void setTempreture(Integer tempreture) {
        this.tempreture = tempreture;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public Integer getWatering() {
        return watering;
    }

    public void setWatering(Integer watering) {
        this.watering = watering;
    }

    public GrowingTips(Integer tempreture, String lighting, Integer watering) {
        this.tempreture = tempreture;
        this.lighting = lighting;
        this.watering = watering;
    }
}
