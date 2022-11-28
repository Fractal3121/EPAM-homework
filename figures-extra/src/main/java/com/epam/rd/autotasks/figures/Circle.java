package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point c;
    double d;

    public Circle(Point c, double d) {
        this.c = c;
        this.d = d;
        if(c == null) throw new IllegalArgumentException();
        if(d <= 0) throw new IllegalArgumentException();
        if(area() == 0)  throw new IllegalArgumentException();

    }

    public double area() {
        //TODO
        double area = Math.PI * d * d;
        return Math.abs(area);
    }

    public Point centroid(){
        return c;
    }

    public boolean isTheSame(Figure figure){
        double delta = 0.000001d;
        if(getClass()!= figure.getClass())return false;
        Circle circ = (Circle) figure;
        if(Math.abs(c.getX() - circ.c.getX())< delta){
            if (Math.abs(c.getY()-circ.c.getY()) < delta){
                if (Math.abs(d - circ.d)<delta)return true;
            }
        }
        return false;
    }
}
