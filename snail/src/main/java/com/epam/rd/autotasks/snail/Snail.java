package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();

        if(a > b || a >= h) {
            int pd = 0;
            int nh = a;
            int d = 1;
            if (a >= h) {
                System.out.println(d);
            }
            else {


            while (nh <= h) {
                d++;
                pd = a - b;
                nh += pd;

                if (nh >= h) {
                    System.out.println(d);
                    break;
                }

            }
        }

        }
        else if(b >= a && b < h){
            System.out.println("Impossible");
        }
    }
}
