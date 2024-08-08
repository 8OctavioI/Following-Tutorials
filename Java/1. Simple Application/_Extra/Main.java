import java.util.Scanner;
import java.text.NumberFormat;


public class Main{
    public static void main(String [] args) {

        UtilFunctions UtilFunctions = new UtilFunctions();
        
        

        int option = -1;

        while (option != 0) {
            String menu = "Apps: \n" +
                        "1. Mortgage Calculator\n" +
                        "2. FizzBuzz\n" + 
                        "0. Exit\n" +
                        "Select an app by inputting the number: ";

            System.out.print(menu);

            

            

            String temp = UtilFunctions.getInput();

            while (!UtilFunctions.isNumeric(temp)) {
                System.out.println("Invalid Option! Try again!! \n " + menu);
                temp = UtilFunctions.getInput();
            }
            

            option = Integer.parseInt(temp);

            switch (option) {
                case 1:
                    (new MortgageCalculator()).run();
                    break;
                case 2:
                    (new FizzBuzz()).run();
                    break;

                default:
                    System.out.println("Exiting!");
                    
            }

            
        }
        
    }
}

class UtilFunctions {

    public boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public String getInput(){
        Scanner2 scn = new Scanner2();
        String str = scn.scanner.nextLine();
        return str;
    }

}

class Scanner2 {
    public Scanner scanner;
    Scanner2(){
        scanner = new Scanner(System.in);
    }
}



class MortgageCalculator {
    public void run() {

        System.out.println("Mortgage Calculator!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = Integer.parseInt(UtilFunctions.getInput());

        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = Double.parseDouble(UtilFunctions.getInput())/100;
        double monthlyInterestRate = annualInterestRate/12;

        System.out.print("Period (years): ");
        double term = Double.parseDouble(UtilFunctions.getInput());
        double numOfPayments = term * 12;

        String mortgage = NumberFormat.getCurrencyInstance().format(principal * 
                                                                    (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfPayments)) / 
                                                                    (Math.pow( 1 + monthlyInterestRate, numOfPayments) - 1));

        System.out.println(String.format("Total Mortgage Payment: %s", mortgage));
        scanner.close();
    }
}




class FizzBuzz {
    public void run() {

        System.out.print("FizzBuzz!!\nEnter a Number: ");

        String temp = UtilFunctions.getInput();

        while(!UtilFunctions.isNumeric(temp)) {
            System.out.println("Invalid Input! Try Again!!");
            temp = UtilFunctions.getInput();
        }

        int input = Integer.parseInt(temp);

        if (input % 5 == 0) {
            if (input % 3 == 0) System.out.println("FizzBuzz!");
            else System.out.println("Fizz!");
        } 
        else if (input % 3 == 0) System.out.println("Buzz!");
        else System.out.println(input);

    }
}
