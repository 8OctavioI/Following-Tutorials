package com.octavioi;


public class FizzBuzz {

    public static void run() {

        int input = UtilFunctions.getValidIntegerInputBetween("FizzBuzz!!\nEnter a Number", 0, 100000);

        if (input % 5 == 0) {
            if (input % 3 == 0) System.out.println("FizzBuzz!");
            else System.out.println("Fizz!");
        } 
        else if (input % 3 == 0) System.out.println("Buzz!");
        else System.out.println(input);

    }
}

