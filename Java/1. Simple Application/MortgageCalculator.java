import java.util.Scanner;
import java.text.NumberFormat;

class MortgageCalculator {
    public void run() {

        System.out.println("Mortgage Calculator!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = Integer.parseInt(scanner.nextLine());

        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = Double.parseDouble(scanner.nextLine())/100;
        double monthlyInterestRate = annualInterestRate/12;

        System.out.print("Period (years): ");
        double term = Double.parseDouble(scanner.nextLine());
        double numOfPayments = term * 12;

        String mortgage = NumberFormat.getCurrencyInstance().format(principal * 
                                                                    (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfPayments)) / 
                                                                    (Math.pow( 1 + monthlyInterestRate, numOfPayments) - 1));

        System.out.println(String.format("Total Mortgage Payment: %s", mortgage));
        scanner.close();
    }
}
