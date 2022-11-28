package com.epam.rd.autotasks.figures;

import java.util.Locale;

import static java.lang.Math.sqrt;

class Quadrilateral extends Figure{
    Point a;
    Point b;
    Point c;
    Point d;

    double length1() {
        return sqrt(Math.pow(this.a.getX()-this.b.getX(), 2) + Math.pow(this.a.getY()-this.b.getY(), 2));
    }
    double length2() {
        return sqrt(Math.pow(this.b.getX()-this.c.getX(), 2) + Math.pow(this.b.getY()-this.c.getY(), 2));
    }

    public Quadrilateral(Point a, Point b, Point c, Point d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    }
    public double area() {
        //TODO
        //double area = length1()*length2();
        double area = Math.abs(a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0f
                + Math.abs(a.getX() * (d.getY() - c.getY()) + d.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - d.getY())) / 2.0f;
        return Math.abs(area);
    }
    public String pointsToString(){
       String s = String.format(Locale.US,"(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)",a.getX(),a.getY(),b.getX(),b.getY(),c.getX(),c.getY(),d.getX(),d.getY());
       return s;
    }
    public String toString(){
        String s = String.format(Locale.US,"Quadrilateral[(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)]",a.getX(),a.getY(),b.getX(),b.getY(),c.getX(),c.getY(),d.getX(),d.getY());
        return s;
    }
    public Point leftmostPoint(){
        Point res = a;
        if(res.getX()>b.getX())res=b;
        if(res.getX()>c.getX())res=c;
        if(res.getX()>d.getX())res=d;

        return res;
    }
}
