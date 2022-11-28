package com.epam.rd.autotasks.triangle;


import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {

    Point a;
    Point b;
    Point c;

    double length1() {
        return sqrt(Math.pow(this.a.getX()-this.b.getX(), 2) + Math.pow(this.a.getY()-this.b.getY(), 2));
    }
    double length2() {
        return sqrt(Math.pow(this.b.getX()-this.c.getX(), 2) + Math.pow(this.b.getY()-this.c.getY(), 2));
    }
    double length3() {
        return sqrt(Math.pow(this.c.getX()-this.a.getX(), 2) + Math.pow(this.c.getY()-this.a.getY(), 2));
    }


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if( length1() < length2() + length3() && length2() < length1() + length3() && length3() < length1() + length2()){
            return;
        }
        else {
            throw new IllegalArgumentException();
        }
        //TODO

    }

    public double area() {
        //TODO
        double area = (a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0f;
        return Math.abs(area);
    }

    public Point centroid(){
        //TODO

        double x1 = a.getX(), x2 = b.getX(), x3 = c.getX();
        double y1 = a.getY(), y2 = b.getY(), y3 = c.getY();


        double x = (x1 + x2 + x3) / 3;
        double y = (y1 + y2 + y3) / 3;


        System.out.println("Centroid = " + "(" + x + ", " + y + ")");
        return new Point(x, y);
    }

}
