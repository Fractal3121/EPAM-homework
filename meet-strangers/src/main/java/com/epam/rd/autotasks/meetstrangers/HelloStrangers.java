package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        ArrayList<String>inputList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number > 0){
            int i;
            for(i = 0 ; i < number + 1; i++ ) {
                String line = scanner.nextLine();
                inputList.add("Hello, " + line);

            }
            inputList.remove(0);
            for (int j = 0; j < inputList.size(); j++)
                System.out.println(inputList.get(j));
        }
        else if(number == 0){
            System.out.println("Oh, it looks like there is no one here");
        }
        else{
            System.out.println("Seriously? Why so negative?");
        }
    }
}
