package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int human = scanner.nextInt();
        int pizza = scanner.nextInt();
        int iteration = 1;
        int plus = pizza;
        while (pizza % human != 0){
            iteration++;
            pizza += plus;
        }

        System.out.println(iteration);


    }
}
