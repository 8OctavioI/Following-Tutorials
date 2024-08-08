import java.util.Scanner;
import java.text.NumberFormat;

class MortgageCalculator {

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

    public static void run() {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        final int MIN_PRINCIPAL = 1_000;
        final int MAX_PRINCIPAL = 1_000_000;

        final byte MIN_INTEREST_RATE = 0;
        final byte MAX_INTEREST_RATE = 30;

        final byte MIN_TERM = 1;
        final byte MAX_TERM = 30;


        System.out.println("Mortgage Calculator!");

        Scanner scanner = new Scanner(System.in);


        System.out.print("Principal: ");

        String temp = scanner.nextLine();
        while(!(isNumeric(temp) && Integer.parseInt(temp) >= MIN_PRINCIPAL && Integer.parseInt(temp) <= MAX_PRINCIPAL)) {
            System.out.print("Invalid Amount. Please input a number between 1,000 and 1,000,000. \nPrincipal: ");
            temp = scanner.nextLine();
        }
        int principal = Integer.parseInt(temp);

        System.out.print("Annual Interest Rate: ");

        temp = scanner.nextLine();
        while(!(isDouble(temp) && Double.parseDouble(temp) > MIN_INTEREST_RATE && Double.parseDouble(temp) <= MAX_INTEREST_RATE)) {
            System.out.print("Invalid Amount. Please input a number between 0 and 30. \nAnnual Interest Rate: ");
            temp = scanner.nextLine();
        }
        double annualInterestRate = Double.parseDouble(temp) / PERCENT;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;

        System.out.print("Period (years): ");

        temp = scanner.nextLine();
        while(!(isNumeric(temp) && Integer.parseInt(temp) >= MIN_TERM && Integer.parseInt(temp) <= MAX_TERM)) {
            System.out.print("Invalid Amount. Please input a number between 1 and 30. \nPeriod (years): ");
            temp = scanner.nextLine();
        }
        double term = Double.parseDouble(temp);
        double numOfPayments = term * MONTHS_IN_YEAR;

        String mortgage = NumberFormat.getCurrencyInstance().format(principal * 
                                                                    (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfPayments)) / 
                                                                    (Math.pow( 1 + monthlyInterestRate, numOfPayments) - 1));

        System.out.println(String.format("Total Mortgage Payment: %s", mortgage));
        scanner.close();
    }
}
