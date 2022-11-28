package com.epam.rd.java.basic.practice1;

public class Part3 {

    public static void main(String[] args) {
                boolean name = false;
        for ( int i = 0 ; i < args.length; i++){
            if (name){
                System.out.print(" ");
            }
             name = true;  
			 System.out.print(args[i]);
        }
    }
	
}
