package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner (System.in);
        int money = scanner.nextInt();
        int friends = scanner.nextInt();

        if (money < 0){
            System.out.println("Bill total amount cannot be negative");
        }

        if (friends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
        }
        if(money >= 0 && friends > 0){
            if(money == 0){
                System.out.println(0);
            }
            else {
                int percent = money / 10;
                money += percent;
                int pay = money / friends;
                System.out.println(pay);
            }
        }

    }
}
