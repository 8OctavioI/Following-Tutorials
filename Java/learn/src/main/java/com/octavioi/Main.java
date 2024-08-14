package com.octavioi;


public class Main {
    
    public static void main(String[] args) {

        int option = -1;

        while (option != 0) {
            String menu = "Apps: \n" +
                        "1. Mortgage Calculator\n" +
                        "2. FizzBuzz\n" + 
                        "0. Exit\n" +
                        "Select an app by inputting the number";

            option = UtilFunctions.getValidIntegerInputBetween(menu, 0, 2);

            switch (option) {
                case 1:
                    MortgageCalculator.run();
                    break;
                case 2:
                    FizzBuzz.run();
                    break;

                default:
                    System.out.println("Exiting!");
                    
            }

            
        }
    }
}