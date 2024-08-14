package com.octavioi;

import java.util.ArrayList;

import com.octavioi.Exceptions.AmountInvalidException;
import com.octavioi.Exceptions.NoAccessException;
import com.octavioi.Exceptions.NotLoggedInException;

public class Main {

    private static String menu = "\n\nMenu: \n" +
                                "1. Create Account\n" +
                                "2. Withdraw Amount\n" +
                                "3. Deposit Amount\n" +
                                "4. Check Balance\n" +
                                "5. Log in\n" +
                                "6. Log Out\n" + 
                                "0. Exit"; 

    
    public static void main(String[] args) {
        Bankable activeAccount = null;
        ArrayList<Bankable> allAvailableAccounts = new ArrayList<Bankable>();

        outer:
        while (true) {
            try {
                System.out.println(menu);
                int option = UtilFunctions.getValidIntegerInputBetween("Select an option", 0, 7);

                switch (option) {
                    case 0:
                        break outer;

                    // Create Account
                    case 1:{
                        allAvailableAccounts.add(createAccount());
                        break;
                    }

                    // Withdraw
                    case 2:{
                        if (activeAccount == null) {
                            throw new NoAccessException(new NotLoggedInException());
                        }
                        activeAccount.withdraw();
                        break;
                    }

                    // Deposit
                    case 3: {
                        if (activeAccount == null) {
                            throw new NoAccessException(new NotLoggedInException());
                        }
                        activeAccount.deposit();
                        break;
                    }

                    // Get Balance
                    case 4:{
                        if (activeAccount == null) {
                            throw new NoAccessException(new NotLoggedInException());
                        }
                        System.out.println("Acquiring Balance!");
                        System.out.println("Your balance is: " + activeAccount.getBalance());
                        break;
                    }

                    // Log in
                    case 5:{
                        if (activeAccount != null) {
                            System.out.println("You're already logged in. Log out to log into another account.");
                            continue;
                        }

                        Bankable account = logIn(allAvailableAccounts);
                        if (account == null) System.out.println("Incorrect Username or Password.");
                        else {
                            activeAccount = account;
                            System.out.println("You have been successfully logged in.");
                        }
                        break;
                    }

                    // Log Out
                    case 6:{
                        if (activeAccount == null) 
                            throw new NoAccessException(new NotLoggedInException());
                        activeAccount = null;
                        System.out.println("You have been logged out.");
                        break;
                    }
                }
            } catch (AmountInvalidException e) {
                e.printStackTrace();
                
                

            } catch (NoAccessException e) {
                e.printStackTrace();

            }
        }
            

    }

    private static Bankable createAccount() {
        System.out.println("Account Creation: ");
        String name = UtilFunctions.getStringInput("Name");
        Double balance = UtilFunctions.getValidDoubleInputBetween("Starting Balance", 0, 10_000);
        String password = UtilFunctions.getStringInput("Password").hashCode() + "";
        System.out.println("Thank you, " + name + "! Your account has been successfully created. Log in to proceed. ");
        return new AccountV1(name, balance, password);
    }
    
    private static Bankable logIn(ArrayList<Bankable> accounts) {
        String name = UtilFunctions.getStringInput("Name");
        String pass = UtilFunctions.getStringInput("Password");
        for (Bankable account : accounts) {
            if (account.getUser().equals(name)) {
                if ((account.getPass()).equals(pass.hashCode() + "")) {
                    return account;
                }
            }
        }
        return null;
    }
}