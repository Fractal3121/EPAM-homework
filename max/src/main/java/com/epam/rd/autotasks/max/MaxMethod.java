package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {

        int largest = values[0];

        for (int i = 0; i < values.length ; i++) {
            if(values[i] > largest) largest = values[i];
        }
        return largest;

        //throw new UnsupportedOperationException();
    }

}
