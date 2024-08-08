import java.util.Scanner;
import java.lang.reflect.Type;
import java.text.NumberFormat;

class MortgageCalculator {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    final static int MIN_PRINCIPAL = 1_000;
    final static int MAX_PRINCIPAL = 1_000_000;

    final static byte MIN_INTEREST_RATE = 0;
    final static byte MAX_INTEREST_RATE = 30;

    final static byte MIN_TERM = 1;
    final static byte MAX_TERM = 30;

    public static void main(String[] args) {
        run();
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static Integer getValidIntegerInputBetween(String fieldName, int MIN_VALUE, int MAX_VALUE, Scanner scanner) {
        String temp;
        while(true) {
            System.out.print(fieldName + ": ");
            temp = scanner.next();
            if (isNumeric(temp) && Integer.parseInt(temp) >= MIN_VALUE && Integer.parseInt(temp) <= MAX_VALUE) break;
            System.out.println(String.format("Invalid Input. Type a number between %d and %d for %s", MIN_VALUE, MAX_VALUE, fieldName));
        }
        return Integer.parseInt(temp);
    }

    public static Double getValidDoubleInputBetween(String fieldName, int MIN_VALUE, int MAX_VALUE, Scanner scanner) {
        String temp;
        while(true) {
            System.out.print(fieldName + ": ");
            temp = scanner.next();
            if (isDouble(temp) && Double.parseDouble(temp) >= MIN_VALUE && Double.parseDouble(temp) <= MAX_VALUE) break;
            System.out.println(String.format("Invalid Input. Type a number between %d and %d for %s", MIN_VALUE, MAX_VALUE, fieldName));
        }
        return Double.parseDouble(temp);
    }

    public static Double calculateMortgage(int principal, Double annualInterestRate, Double term) {
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        double numOfPayments = term * MONTHS_IN_YEAR;
        return principal * 
            (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfPayments)) / 
            (Math.pow( 1 + monthlyInterestRate, numOfPayments) - 1);
    }

    public static Double calculateRemainingLoanBalance(int principal, Double annualInterestRate, Double term, int numOfPaymentsMade) {
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        double numOfPayments = term * MONTHS_IN_YEAR;
        
        return principal * 
                (Math.pow(1 + monthlyInterestRate, numOfPayments) - Math.pow(1 + monthlyInterestRate, numOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterestRate, numOfPayments) - 1);
    }

    public static String calculatePaymentSchedule(int principal, Double annualInterestRate, Double term) {
        String paymentSchedule = "PAYMENT SCHEDULE\n----------------\n";

        double numOfPayments = term * MONTHS_IN_YEAR;

        for (int i = 1; i <= numOfPayments; i++) {
            paymentSchedule += NumberFormat.getCurrencyInstance().format(calculateRemainingLoanBalance(principal, annualInterestRate, term, i)) + "\n";
        }

        return paymentSchedule;
    }
    
    public static void run() {

        System.out.println("Mortgage Calculator!");

        Scanner scanner = new Scanner(System.in);

        int principal = getValidIntegerInputBetween("Principal", MIN_PRINCIPAL, MAX_PRINCIPAL, scanner);
        double annualInterestRate = getValidDoubleInputBetween("Annual Interest Rate", MIN_INTEREST_RATE, MAX_INTEREST_RATE, scanner) / PERCENT;
        double term = getValidDoubleInputBetween("Period (years)", MIN_TERM, MAX_TERM, scanner);
        

        String mortgage = NumberFormat.getCurrencyInstance().format(calculateMortgage(principal, annualInterestRate, term));

        System.out.println(String.format("Total Mortgage Payment: %s", mortgage));

        System.out.println(calculatePaymentSchedule(principal, annualInterestRate, term));

        scanner.close();
        
    }
}
