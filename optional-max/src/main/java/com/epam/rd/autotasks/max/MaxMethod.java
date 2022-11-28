package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if(values != null && values.length > 0) {
            int largest = values[0];
            for (int i = 0; i < values.length; i++) {
                if(largest < values[i]) largest = values[i];
            }
            return OptionalInt.of(largest);
        }
        return OptionalInt.empty();
        //throw new UnsupportedOperationException();
    }
}
