package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;
    Point x1;
    Point x2;
    Point y1;
    Point y2;

    public Segment(Point start, Point end) {
        if (start.getX()==end.getX() && start.getY()==end.getY()) throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(Math.pow(this.start.getX()-this.end.getX(), 2) + Math.pow(this.start.getY()-this.end.getY(), 2));
    }

    Point middle() {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        return new Point((x1+x2)/2, (y1+y2)/2);
    }

    Point intersection(Segment another) {

        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();

        double x3 = another.start.getX();
        double x4 = another.end.getX();
        double y3 = another.start.getY();
        double y4 = another.end.getY();

        double delim = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        if (delim == 0) return null;

        double x = ((x1*y2-y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4)) / delim;
        double y = ((x1*y2-y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4)) / delim;

        if ((((x <= x1 && x >= x2)|| (x<=x2 && x >= x1)) && ((y <= y1 && y >= y2)||(y <= y2 && y >= y1))) && (((x <= x3 && x >= x4)|| (x<=x4 && x >= x3)) && ((y <= y3 && y >= y4)||(y <= y4 && y >= y3)))) return new Point(x, y);
        return null;
    }

}
