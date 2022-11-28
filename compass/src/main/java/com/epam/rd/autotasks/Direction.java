package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        int deg = 0;
        if(degrees > 360){
            deg = degrees % 360;
        }
        else deg += degrees;
        if (deg<0)deg+=360;
        switch (deg){
            case 0:
            case 360:return Direction.N;
            case 45: return Direction.NE;
            case 90: return  Direction.E;
            case 135: return Direction.SE;
            case 180: return Direction.S;
            case 225: return  Direction.SW;
            case 270: return Direction.W;
            case 315: return  Direction.NW;
            default: return null;
        }

        //throw new UnsupportedOperationException();
    }

    public static Direction closestToDegrees(int degrees) {
        int deg = 0;
        int sect = 0;
        double b = degrees % 45;
        int ansv;
        if(degrees > 360){
            deg = degrees % 360;
        }
        else deg += degrees;
        if (deg<0)deg+=360;
        sect = deg / 45;
        Math.round(sect);
        if (b > 22.5)sect++;
        ansv = sect * 45;
        switch (ansv){
            case 0:
            case 360:return Direction.N;
            case 45: return Direction.NE;
            case 90: return  Direction.E;
            case 135: return Direction.SE;
            case 180: return Direction.S;
            case 225: return  Direction.SW;
            case 270: return Direction.W;
            case 315: return  Direction.NW;
            default: return null;
        }

        //throw new UnsupportedOperationException();
    }

    public Direction opposite() {
        int deg = 0;
        if(degrees > 360){
            deg = degrees % 360;
        }
        else deg += degrees;
        if (deg<0)deg+=360;
        switch (deg){
            case 0:
            case 360:return Direction.S;
            case 45: return Direction.SW;
            case 90: return  Direction.W;
            case 135: return Direction.NW;
            case 180: return Direction.N;
            case 225: return  Direction.NE;
            case 270: return Direction.E;
            case 315: return  Direction.SE;
            default: return null;
        }

        //throw new UnsupportedOperationException();
    }

    public int differenceDegreesTo(Direction direction) {
        int result;
        result = direction.degrees - degrees;
        if (result > 180) result -= 360;
        return Math.abs(result);
    }
}
