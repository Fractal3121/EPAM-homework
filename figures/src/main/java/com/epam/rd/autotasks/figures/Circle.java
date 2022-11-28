package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Circle extends Figure{
    Point c;
    double d;

    public Circle(Point c, double d) {
        this.c = c;
        this.d = d;

    }
    public double area() {
        //TODO
        double area = Math.PI * d * d;
        return Math.abs(area);
    }
    public String pointsToString(){
        String s = String.format(Locale.US,"(%.1f,%.1f)",c.getX(),c.getY());
        return s;
    }
    public String toString(){
        String val = String.valueOf(d);

        String s = String.format(Locale.US,"Circle[(%.1f,%.1f)%s]",c.getX(),c.getY(),val);
        return s;
    }
    public Point leftmostPoint(){

    return new Point(c.getX()-d, c.getY());
    }
}
