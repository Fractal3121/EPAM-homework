package com.epam.rd.java.basic.task8.models;

public class VisualParameters {

    private String stemColour;
    private String leafColour;
    private Integer aveLenFlower;

    public String getStemColour() {
        return stemColour;
    }

    public void setStemColour(String stemColour) {
        this.stemColour = stemColour;
    }

    public String getLeafColour() {
        return leafColour;
    }

    public void setLeafColour(String leafColour) {
        this.leafColour = leafColour;
    }

    public Integer getAveLenFlower() {
        return aveLenFlower;
    }

    public void setAveLenFlower(Integer aveLenFlower) {
        this.aveLenFlower = aveLenFlower;
    }

    public VisualParameters(String stemColour, String leafColour, Integer aveLenFlower) {
        this.stemColour = stemColour;
        this.leafColour = leafColour;
        this.aveLenFlower = aveLenFlower;
    }
}
