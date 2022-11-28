package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if(array.length != 0){
            int num = array[array.length - 1];
            for (int i = array.length - 2; i > -1; i--) {

                array[i + 1] = array[i];
            }
            array[0] = num;
        }
    }


    static void cycleSwap(int[] array, int shift) {
        if (array.length != 0) {
            if (shift > 0) {
                for (int i = 0; i < shift; i++) {
                    int num = array[array.length - 1];

                    for (int j = array.length - 1; j > 0; j--) {
                        array[j] = array[j - 1];
                    }

                    array[0] = num;
                }
            } else {
                for (int i = 0; i > shift; i--) {
                    int num = array[0];

                    for (int j = 1; j < array.length; j++) {
                        array[j - 1] = array[j];
                    }

                    array[array.length - 1] = num;
                }
            }

        }
    }
}
