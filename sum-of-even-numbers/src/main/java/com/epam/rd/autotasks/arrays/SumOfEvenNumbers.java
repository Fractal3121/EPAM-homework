package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){
        int suma = 0;
        if (array == null){
            suma = 0;
        }
        else{
            for (int counter = 0; counter < array.length ; counter++) {
                if(array[counter] % 2 == 0) {
                    suma += array[counter];
                }
                else {
                    suma += 0;
                }
            }
        }
        //put your code here
        return suma;
        //throw new UnsupportedOperationException();
    }
}
