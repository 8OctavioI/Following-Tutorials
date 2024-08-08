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

        System.out.println("Mortgage Calculator!");

        Scanner scanner = new Scanner(System.in);


        System.out.print("Principal: ");

        String temp = scanner.nextLine();
        while(!(isNumeric(temp) && Integer.parseInt(temp) >= 1_000 && Integer.parseInt(temp) <= 1_000_000)) {
            System.out.print("Invalid Amount. Please input a number between 1,000 and 1,000,000. \nPrincipal: ");
            temp = scanner.nextLine();
        }
        int principal = Integer.parseInt(temp);

        System.out.print("Annual Interest Rate: ");

        temp = scanner.nextLine();
        while(!(isDouble(temp) && Double.parseDouble(temp) > 0 && Double.parseDouble(temp) <= 30)) {
            System.out.print("Invalid Amount. Please input a number between 0 and 30. \nAnnual Interest Rate: ");
            temp = scanner.nextLine();
        }
        double annualInterestRate = Double.parseDouble(temp)/100;
        double monthlyInterestRate = annualInterestRate/12;

        System.out.print("Period (years): ");

        temp = scanner.nextLine();
        while(!(isNumeric(temp) && Integer.parseInt(temp) > 0 && Integer.parseInt(temp) <= 30)) {
            System.out.print("Invalid Amount. Please input a number between 1 and 30. \nPeriod (years): ");
            temp = scanner.nextLine();
        }
        double term = Double.parseDouble(temp);
        double numOfPayments = term * 12;

        String mortgage = NumberFormat.getCurrencyInstance().format(principal * 
                                                                    (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfPayments)) / 
                                                                    (Math.pow( 1 + monthlyInterestRate, numOfPayments) - 1));

        System.out.println(String.format("Total Mortgage Payment: %s", mortgage));
        scanner.close();
    }
}
