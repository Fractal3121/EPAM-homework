package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    Point a;
    Point b;
    Point c;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if(a == null||b==null||c==null) throw new IllegalArgumentException();
        if(area() == 0) throw new IllegalArgumentException();

    }

    public double area() {
        //TODO
        double area = (a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0f;
        return Math.abs(area);
    }

    public Point centroid(){

        double x1 = a.getX();
        double x2 = b.getX();
        double x3 = c.getX();

        double y1 = a.getY();
        double y2 = b.getY();
        double y3 = c.getY();

        double x = (x1 + x2 + x3) / 3;
        double y = (y1 + y2 + y3) / 3;

        return new Point(x, y);

    }

    public boolean isTheSame(Figure figure){
        if(getClass()!= figure.getClass())throw new IllegalArgumentException();
        Triangle tri = (Triangle)figure;
        if(a.getX() == tri.b.getX()||a.getX() == tri.a.getX()||a.getX() == tri.c.getX()) {
            if (a.getY() == tri.b.getY() || a.getY() == tri.a.getY() || a.getY() == tri.c.getY()) {
                if (b.getX() == tri.b.getX() || b.getX() == tri.a.getX() || b.getX() == tri.c.getX()) {
                    if (b.getY() == tri.a.getY() || b.getY() == tri.b.getY() || b.getY() == tri.c.getY()) {
                        if (c.getX() == tri.b.getX() || c.getX() == tri.a.getX() || c.getX() == tri.c.getX()) {
                            if (c.getY() == tri.a.getY() || c.getY() == tri.b.getY() || c.getY() == tri.c.getY()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
