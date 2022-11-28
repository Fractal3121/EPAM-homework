package com.epam.rd.java.basic.practice1;

public class Part4 {

    public static void main(String[] args) {
                int[] myInts = new int[2];
        for (int i = 0; i < Math.min(2, args.length); i++)
            myInts[i] = Integer.parseInt(args[i]);

            int num1 = myInts[0], num2 = myInts[1];


            while (num1 != num2) {
                if (num1 > num2)
                    num1 = num1 - num2;
                else
                    num2 = num2 - num1;
            }

            System.out.printf("%d", num2);

    }

}
