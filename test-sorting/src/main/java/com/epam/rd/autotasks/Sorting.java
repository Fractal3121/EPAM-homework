package com.epam.rd.autotasks;

public class Sorting {

    public void sort(int[] array){

        if(array == null){
            throw new IllegalArgumentException();
        }


        if(array.length >= 2) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int a = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = a;
                    i = 1;
                }
            }
        }

    }
}
