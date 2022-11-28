package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialBadInputTesting {

    Factorial factorial = new Factorial();

    @Test()
    void testNullInput(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
                factorial.factorial("");
        });
    }

    @Test
    void testNegativeInput(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            factorial.factorial("-3");
        });
    }

    @Test
    void testFractionalInput(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            factorial.factorial("3.6");
        });
    }

    @Test
    void testNonDigitalInput(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            factorial.factorial("Felix");
        });
    }


}
