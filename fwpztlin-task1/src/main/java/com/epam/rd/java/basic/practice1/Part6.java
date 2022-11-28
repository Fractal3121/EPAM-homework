package com.epam.rd.java.basic.practice1;

public class Part6 {

    static final  String ERROR_MESSAGE = "Wrong input";

    public static void main(String[] args) {
        if(args.length==0){
            System.out.println(ERROR_MESSAGE);
        }
        int size;
        try{
            size = Integer.parseInt(args[0]);
            int[] simpleNumbers = simpleArray(size);
            outputArray(simpleNumbers);
        } catch (final NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
        }
        
    }
    
      private static void outputArray(int[] arr) {
         if (arr.length > 0) {
            for ( int i=0; i< arr.length-1 ; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[arr.length-1]);
        }
    }

    private static int[] simpleArray(int size) {
        int[] arr = new int[size];
        int number = 2;
        for (int i = 0; i < size; i++) {
            while (true) {
                if (isSimple(number)) {
                    arr[i] = number;
                    number++;
                    break;
                }
                number++;
            }
        }
        return arr;
    }

    private static boolean isSimple(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;

    }
  
}