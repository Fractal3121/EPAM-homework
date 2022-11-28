package com.epam.rd.autotasks;

public class Factorial {
    public String factorial(String n) {

        try {
            long fact = Integer.parseInt(n.trim());

            if (fact < 0) {throw new IllegalArgumentException();}
            if (fact == 0) { return "1"; }

            long result = 1;

            for (int i = 1; i <= fact; i++) {
                result *= i;
            }
            return String.valueOf(result);
        }

        catch (IllegalArgumentException ill){
            throw new IllegalArgumentException();
        }
    }
}
