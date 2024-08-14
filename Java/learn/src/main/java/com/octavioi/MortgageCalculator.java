package com.octavioi;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    
    private final static int MIN_PRINCIPAL = 1_000;
    private final static int MAX_PRINCIPAL = 1_000_000;

    private final static byte MIN_INTEREST_RATE = 0;
    private final static byte MAX_INTEREST_RATE = 30;

    private final static byte MIN_TERM = 1;
    private final static byte MAX_TERM = 30;

    private static double monthlyInterestRate(Double annualInterestRate) {
        return annualInterestRate / MONTHS_IN_YEAR;
    }

    private static Double totalNumOfPayments(Double term) {
        return term * MONTHS_IN_YEAR;
    }


    private static Double calculateMortgage(int principal, Double annualInterestRate, Double term) {
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        double numOfPayments = term * MONTHS_IN_YEAR;
        return principal * 
            (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfPayments)) / 
            (Math.pow( 1 + monthlyInterestRate, numOfPayments) - 1);
    }

    private static Double calculateRemainingLoanBalance(int principal, Double annualInterestRate, Double term, int numOfPaymentsMade) {
        double monthlyInterestRate = monthlyInterestRate(annualInterestRate);
        double numOfPayments = totalNumOfPayments(term);
        
        return principal * 
                (Math.pow(1 + monthlyInterestRate, numOfPayments) - Math.pow(1 + monthlyInterestRate, numOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterestRate, numOfPayments) - 1);
    }

    private static String calculatePaymentSchedule(int principal, Double annualInterestRate, Double term) {
        String paymentSchedule = "PAYMENT SCHEDULE\n----------------\n";

        double numOfPayments = totalNumOfPayments(term);

        for (int i = 1; i <= numOfPayments; i++) {
            paymentSchedule += NumberFormat.getCurrencyInstance().format(calculateRemainingLoanBalance(principal, annualInterestRate, term, i)) + "\n";
        }

        return paymentSchedule;
    }
    
    public static void run() {

        System.out.println("Mortgage Calculator!");

        int principal = UtilFunctions.getValidIntegerInputBetween("Principal", MIN_PRINCIPAL, MAX_PRINCIPAL);
        double annualInterestRate = UtilFunctions.getValidDoubleInputBetween("Annual Interest Rate", MIN_INTEREST_RATE, MAX_INTEREST_RATE) / PERCENT;
        double term = UtilFunctions.getValidDoubleInputBetween("Period (years)", MIN_TERM, MAX_TERM);
        

        String mortgage = NumberFormat.getCurrencyInstance().format(calculateMortgage(principal, annualInterestRate, term));

        System.out.println(String.format("Total Mortgage Payment: %s", mortgage));

        System.out.println(calculatePaymentSchedule(principal, annualInterestRate, term));

        
    }
}
