package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Triangle extends Figure {
    Point a;
    Point b;
    Point c;


    public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
    }

    public double area() {
        //TODO
        double area = (a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0f;
        return Math.abs(area);
    }
    public String pointsToString(){

        String t = String.format(Locale.US,"(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)",a.getX(),a.getY(),b.getX(),b.getY(),c.getX(),c.getY());
        return t;
    }
    public String toString(){
        String t = String.format(Locale.US,"Triangle[(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)]",a.getX(),a.getY(),b.getX(),b.getY(),c.getX(),c.getY());
        return t;
    }
    public Point leftmostPoint(){
        Point res = a;
        if(res.getX()>b.getX())res=b;
        if(res.getX()>c.getX())res=c;

        return res;
    }
}

