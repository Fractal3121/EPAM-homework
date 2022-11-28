package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuadraticEquationZeroACasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    private double a;
    private double b;
    private double c;

    public QuadraticEquationZeroACasesTesting(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][]{
                {0, 5, 6},
                {0, 1, -3},
                {0, 1, -6},
                {0, -11, 3}
        });
    }
    @Test(expected = IllegalArgumentException.class)
    public void TwoRootsCases(){
        quadraticEquation.solve(a,b,c);
    }

}
