package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if(a==b||a==c||a==d||b==c||b==d||c==d)throw new IllegalArgumentException();
        if(a == null||b==null||c==null||d==null) throw new IllegalArgumentException();
        if(area() == 0)  throw new IllegalArgumentException();
        if(area2() == 0)  throw new IllegalArgumentException();
        if(area() != area2())  throw new IllegalArgumentException();
        if(centroid()== null) throw new IllegalArgumentException();
        //if(intersection() == false) throw new IllegalArgumentException();
    }

    public double area() {
        //TODO
        double tri1 = Math.abs(a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0f;
        double tri2 = Math.abs(a.getX() * (d.getY() - c.getY()) + d.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - d.getY())) / 2.0f;
        if(tri1==0||tri2==0)throw new IllegalArgumentException();
        double area = tri1 + tri2;
        return Math.abs(area);
    }
    public double area2() {
        //TODO
        double tri1 = Math.abs(d.getX() * (a.getY() - b.getY()) + a.getX() * (b.getY() - d.getY()) + b.getX() * (d.getY() - a.getY())) / 2.0f;
        double tri2 = Math.abs(d.getX() * (c.getY() - b.getY()) + c.getX() * (b.getY() - d.getY()) + b.getX() * (d.getY() - c.getY())) / 2.0f;
        if(tri1==0||tri2==0)throw new IllegalArgumentException();
        double area = tri1 + tri2;
        return Math.abs(area);
    }

    public boolean intersection() {

        double a1 = b.getY() - a.getY();
        double b1 = a.getX() - b.getX();
        double a2 = d.getY() - c.getY();
        double b2 = c.getX() - d.getX();

        double c1 = b.getY() - c.getY();
        double d1 = c.getX() - b.getX();
        double c2 = d.getY() - a.getY();
        double d2 = a.getX() - d.getX();

        double determinant = a1*b2 - a2*b1;
        double determinant2 = c1*d2 - c2*d1;

        if (determinant != 0 || determinant2 != 0)return false;
        return true;

//        Point ab = a.getVector(b);
//        Point ad = a.getVector(d);
//        Point bc = b.getVector(c);
//        Point ba = b.getVector(a);
//        Point cd = c.getVector(d);
//        Point cb = c.getVector(b);
//        Point da = d.getVector(a);
//        Point dc = d.getVector(c);
//
//        double Vect1 = ab.angle(ad);
//        double Vect2 = ba.angle(bc);
//        double Vect3 = cb.angle(cd);
//        double Vect4 = dc.angle(da);
//
//        double sum = Vect1 + Vect2 + Vect3 + Vect4;

    }


    public Point centroid(){
//        if(a.getX() == c.getX()||b.getX()==d.getX() )throw new IllegalArgumentException();
//        if(a.getY() == c.getY()||b.getY()==d.getY() )throw new IllegalArgumentException();

        double xA = a.getX();
        double xB = b.getX();
        double xC = c.getX();
        double xD = d.getX();

        double yA = a.getY();
        double yB = b.getY();
        double yC = c.getY();
        double yD = d.getY();
        //Point E
        double xE = (xA + xB + xC) / 3;
        double yE = (yA + yB + yC) / 3;

        //Point F
        double xF = (xA + xD + xC) / 3;
        double yF = (yA + yD + yC) / 3;

        //Point G
        double xG = (xA + xB + xD) / 3;
        double yG = (yA + yB + yD) / 3;

        //Point L
        double xL = (xC + xB + xD) / 3;
        double yL = (yC + yB + yD) / 3;

        double delim = (xF-xE)*(yG-yL) - (yF-yE)*(xG-xL);
        if (delim == 0) return null;

        double x = ((xF*yE-yF*xE)*(xG-xL) - (xF-xE)*(xG*yL-yG*xL)) / delim;
        double y = ((xF*yE-yF*xE)*(yG-yL) - (yF-yE)*(xG*yL-yG*xL)) / delim;

        if ((((x <= xF && x >= xE)|| (x<=xE && x >= xF)) && ((y <= yF && y >= yE)||(y <= yE && y >= yF))) && (((x <= xG && x >= xL)|| (x<=xL && x >= xG)) && ((y <= yG && y >= yL)||(y <= yL && y >= yG)))) return new Point(x, y);
        return null;

    }

    public boolean isTheSame(Figure figure){
        double delta = 0.000001d;
        if(getClass()!= figure.getClass())throw new IllegalArgumentException();
        Quadrilateral quad = (Quadrilateral)figure;

        if(Math.abs(a.getX() - quad.b.getX())<delta||Math.abs(a.getX() - quad.a.getX())<delta||Math.abs(a.getX() - quad.c.getX())<delta||Math.abs(a.getX() - quad.d.getX())<delta) {
            if (Math.abs(a.getY() - quad.b.getY())<delta || Math.abs(a.getY() - quad.a.getY())<delta || Math.abs(a.getY() - quad.c.getY())<delta|| Math.abs(a.getY() - quad.d.getY())<delta) {
                if (Math.abs(b.getX() - quad.b.getX())<delta||Math.abs(b.getX() - quad.a.getX())<delta||Math.abs(b.getX() - quad.c.getX())<delta||Math.abs(b.getX() - quad.d.getX())<delta) {
                    if (Math.abs(b.getY() - quad.b.getY())<delta || Math.abs(b.getY() - quad.a.getY())<delta || Math.abs(b.getY() - quad.c.getY())<delta|| Math.abs(b.getY() - quad.d.getY())<delta) {
                        if (Math.abs(c.getX() - quad.b.getX())<delta||Math.abs(c.getX() - quad.a.getX())<delta||Math.abs(c.getX() - quad.c.getX())<delta||Math.abs(c.getX() - quad.d.getX())<delta) {
                            if (Math.abs(c.getY() - quad.b.getY())<delta || Math.abs(c.getY() - quad.a.getY())<delta || Math.abs(c.getY() - quad.c.getY())<delta|| Math.abs(c.getY() - quad.d.getY())<delta) {
                                if(Math.abs(d.getX() - quad.b.getX())<delta||Math.abs(d.getX() - quad.a.getX())<delta||Math.abs(d.getX() - quad.c.getX())<delta||Math.abs(d.getX() - quad.d.getX())<delta) {
                                    if (Math.abs(d.getY() - quad.b.getY())<delta || Math.abs(d.getY() - quad.a.getY())<delta || Math.abs(d.getY() - quad.c.getY())<delta|| Math.abs(d.getY() - quad.d.getY())<delta) {
                                        return true;
                                    }
                            }
                        }
                    }
                }
            }
        }
    }
        return false;
    }
}
