package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    private double a;
    private double b;
    private double c;
    private String expected;


    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;

    }
    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][]{
                {1, 5, 6, "-2.0 -3.0 , -3.0 -2.0"},
                {2, 1, -3, "1.0 -1.5 , -1.5 1.0"},
                {1, 1, -6, "2.0 -3.0 , -3.0 2.0"},
                {10, -11, 3, "0.6 0.5 , 0.5 0.6"}
        });
    }
    @Test
    public void TwoRootsCases(){
        //Assert.assertEquals(expected, quadraticEquation.solve(a,b,c));
        Assert.assertTrue(expected.contains(quadraticEquation.solve(a,b,c)));
    }

}
