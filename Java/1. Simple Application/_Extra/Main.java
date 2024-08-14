import java.util.Scanner;
import java.text.NumberFormat;


public class Main{

    Scanner scanner = new Scanner(System.in);
    public static void main(String [] args) {

        
        
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
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        return str;
        
    }

}



class MortgageCalculator {
    
    public void run() {
        UtilFunctions UtilFunctions = new UtilFunctions();

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
        UtilFunctions UtilFunctions = new UtilFunctions();


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
