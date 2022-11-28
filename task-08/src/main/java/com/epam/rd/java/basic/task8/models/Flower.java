package com.epam.rd.java.basic.task8.models;

import java.util.List;

public class Flower {

    private String name;
    private String soil;
    private String origin;
    private List<VisualParameters> visualParameters;
    private List<GrowingTips> growingTips;
    private String multiplying;

    public Flower(String name, String soil, String origin, List<VisualParameters> visualParameters,
                  List<GrowingTips> growingTips, String multiplying) {
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<VisualParameters> getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(List<VisualParameters> visualParameters) {
        this.visualParameters = visualParameters;
    }

    public List<GrowingTips> getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(List<GrowingTips> growingTips) {
        this.growingTips = growingTips;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }
}
