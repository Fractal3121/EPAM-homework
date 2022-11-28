package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        //put your code here
        int count = 0;
        int len = array.length;
        int [] index = new int[len];

        if(array[0]<= array[1]){
            index[0] = 1;
            count++;
        }
        else{
            index[0] = 0;
        }
        if(array[len-1] <= array[len-2]){
            index[len-1] = 1;
            count++;
        }
        else{
            index[len-1] = 0;
        }

        for (int i = 1; i < len-1; i++) {
            if (array[i-1] >= array[i] || array[i] <= array[i+1] ){

                count++;
                index[i] = 1;
            }
            else {
                index[i] = 0;
            }
        }
        int [] max = new int[count];
        count = 0;
        for (int i = 0; i < len; i++) {
            if (index[i] == 1){
                max[count] = array[i];
                ++count;
            }
        }
        return max;
        //throw new UnsupportedOperationException();
    }
}
