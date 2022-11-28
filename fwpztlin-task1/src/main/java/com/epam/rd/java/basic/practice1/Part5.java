package com.epam.rd.java.basic.practice1;

public class Part5 {

    public static void main(String[] args) {
                 for (String str : args) {
            int a = Integer.parseInt(str);
            int n = a;
            System.out.print(getSum(n));
        }	
    }
    static int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }
	
}
