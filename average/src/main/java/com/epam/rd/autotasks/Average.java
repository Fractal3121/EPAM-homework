package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        int suma = scanner.nextInt();
        int t=1;
        while (scanner.hasNextInt()){
            int input = scanner.nextInt();

            if(input == 0){
                break;
            }
            else{
                t++;
                suma += input;
            }
        }
        System.out.println(suma / t);
    }

}