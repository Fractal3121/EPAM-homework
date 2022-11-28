package com.epam.rd.autotasks;

import java.util.stream.Stream;

public class QuadraticEquation {
    public String solve(double a, double b, double c) {

        if (a == 0) {
            throw new IllegalArgumentException();
        }
        double discriminant = (b * b) - (4 * a * c);
        if(discriminant > 0){
            double x1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2*a);
            return x1 + " " + x2;

        }
        if(discriminant == 0){
            double x1 = (-b + Math.sqrt(discriminant)) / (2*a);
            return String.valueOf(x1);

        }
        if(discriminant < 0){
            return "no roots";
        }
        return "no roots";


    }
}
