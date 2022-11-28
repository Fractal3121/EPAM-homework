package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

//    public double angle(Point a){
//        double scal = this.getX()*a.getX()+ this.getY()*a.getY();
//        double dob = this.getlength()*a.getlength();
//        return Math.toDegrees(Math.acos(scal/dob));
//    }
//    public double getlength(){
//        return Math.sqrt(this.getX()*this.getX()+this.getY()*this.getY());
//    }
//    public Point getVector(Point a){
//        return new Point(this.getX()-a.getX(), this.getY()-a.getY());
    //}
}
