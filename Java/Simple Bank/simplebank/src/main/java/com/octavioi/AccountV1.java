package com.octavioi;

import com.octavioi.Exceptions.*;


public class AccountV1 implements Bankable {
    private Double balance;
    private String name;
    private String password;

    AccountV1(String name) {
        balance = 0D;
    }

    AccountV1(String name, Double amount, String password) {
        this.balance = amount;
        this.name = name;
        this.password = password;
    }




    @Override
    public Double withdraw() throws AmountInvalidException {
        System.out.println("Withdraw!");
        Double amount = UtilFunctions.getValidDoubleInputBetween("Amount to withdraw", 0, 10_000);

        if (amount > balance) 
            throw new AmountInvalidException(new InsufficientFundsException());
        
        balance -= amount;

        return balance;
    }

    @Override
    public Double deposit() throws AmountInvalidException{
        //Not implementing Exception here because, it can be handled by the getValidInputFunction. 
        System.out.println("Deposit!");
        balance += UtilFunctions.getValidDoubleInputBetween("Amount to deposit", 0, 10_000);
        
        return balance;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public String getUser() {
        return name;
    }

    @Override
    public String getPass() {
        return password;
    }
}
