// package rubankAssignment2;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TransactionManager {

    // public static Account createAccount(String accountType, String fName, String lName, String dob, double deposit){
    //     try{
    //         Profile tempP = new Profile(fName, lName, dob);
    //         // Account tempA = new Account();
    //     }
    //     catch (RuntimeException e){
    //         System.out.println(e.getMessage());
    //     }
    // }
    public static void run(){
        System.out.println("Transaction Manager is running.");
        Scanner scan = new Scanner(System.in);
        AccountDatabase activeDatabase = new AccountDatabase();
        while(true){
            String textCommand = scan.nextLine();
            if(textCommand.equals("Q")) {
                System.out.println("Transaction Manager is terminated.");
                break;
            }
            String[] commands = textCommand.split("\\s+");
            if(commands.length > 0){
                try{
                    if(commands[0].equals("P"))
                    {
                        activeDatabase.printSorted();
                    }
                    else if(commands[0].equals("PI"))
                    {
                        activeDatabase.printFeesAndInterests();
                    }
                    else if(commands[0].equals("UB"))
                    {
                        activeDatabase.printUpdatedBalance();
                    }
                    else if(commands[0].equals("C")){
                        if(commands.length == 5){
                            Calendar today = Calendar.getInstance();
                            Date tempD = new Date(commands[4]);
                            Date tempTD = new Date((today.get(Calendar.MONTH)+1)+ "/" + today.get(Calendar.DAY_OF_MONTH) + "/" + today.get(Calendar.YEAR));
                            if(tempD.compareTo(tempTD) == 1 || tempD.compareTo(tempTD) == 0){
                                throw new InputMismatchException("DOB invalid: "+ commands[4] + " cannot be today or a future day.");
                            }
                            if(!tempD.isValid()){
                                throw new InputMismatchException("DOB invalid: "+ commands[4] + " not a valid calendar date!");
                            }
                            if(!tempD.underAge()){
                                throw new InputMismatchException("DOB invalid: "+ commands[4] + " under 16.");
                            }
                            Profile tempP = new Profile(commands[2], commands[3], commands[4]);
                            if(commands[1].equals("C")){
                                Checking tempC = new Checking(tempP, 0);
                                if(activeDatabase.contains(tempC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.close(tempC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "has been closed.");
                                }
                            }
                            else if(commands[1].equals("MM")){
                                MoneyMarket tempC = new MoneyMarket(tempP, 0, 0);
                                if(activeDatabase.contains(tempC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.close(tempC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + "has been closed.");
                                }
                            }
                            else if(commands[1].equals("CC")){
                                if(tempD.overAge()){
                                    throw new InputMismatchException("DOB invalid: "+ commands[4] + " over 24.");
                                }
                                CollegeChecking tempCC = new CollegeChecking(tempP, 0, Campus.NEW_BRUNSWICK);
                                if(activeDatabase.contains(tempCC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.close(tempCC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "has been closed.");
                                }
                            }
                            else if(commands[1].equals("S")){
                                Savings tempS = new Savings(tempP, 0, 1);
                                if(activeDatabase.contains(tempS) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.close(tempS);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "has been closed.");
                                }
                            }
                            else{
                                throw new NullPointerException("Invalid command!");
                            }
                        }
                        else{
                            throw new NoSuchElementException("Missing data for closing an account.");
                        }
                    }
                    else if(commands[0].equals("D")) {
                        if(commands.length == 6){
                            //Work in progress
                            Calendar today = Calendar.getInstance();
                            Date tempD = new Date(commands[4]);
                            Date tempTD = new Date((today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DAY_OF_MONTH) + "/" + today.get(Calendar.YEAR));
                            if (tempD.compareTo(tempTD) > 0 || tempD.compareTo(tempTD) == 0) {
                                throw new InputMismatchException("DOB invalid: " + commands[4] + " cannot be today or a future day.");
                            }
                            if (!tempD.isValid()) {
                                throw new InputMismatchException("DOB invalid: " + commands[4] + " not a valid calendar date!");
                            }
                            if (!tempD.underAge()) {
                                throw new InputMismatchException("DOB invalid: " + commands[4] + " under 16.");
                            }
                            double deposit;
                            try {
                                deposit = Double.parseDouble(commands[5]);
                            } catch (NumberFormatException e) {
                                throw new NumberFormatException("Not a valid amount.");
                            }
                            if (deposit < 1) {
                                throw new InputMismatchException("Deposit - amount cannot be 0 or negative.");
                            }
                            Profile tempP = new Profile(commands[2], commands[3], commands[4]);
                            if(commands[1].equals("C")){
                                Checking tempC = new Checking(tempP, deposit);
                                if(activeDatabase.contains(tempC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.deposit(tempC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "Deposit - balance updated.");
                                }
                            }
                            else if(commands[1].equals("MM")){
                                MoneyMarket tempC = new MoneyMarket(tempP, deposit, 0);
                                if(activeDatabase.contains(tempC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.deposit(tempC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + "Deposit - balance updated.");
                                }
                            }
                            else if(commands[1].equals("CC")){
                                if(tempD.overAge()){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is not in the database.");
                                }
                                CollegeChecking tempCC = new CollegeChecking(tempP, deposit, Campus.NEW_BRUNSWICK);
                                if(activeDatabase.contains(tempCC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.deposit(tempCC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "Deposit - balance updated.");
                                }
                            }
                            else if(commands[1].equals("S")){
                                Savings tempS = new Savings(tempP, deposit, 1);
                                if(activeDatabase.contains(tempS) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "is not in the database.");
                                }
                                else{
                                    activeDatabase.deposit(tempS);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "Deposit - balance updated.");
                                }
                            }
                            else{
                                throw new NullPointerException("Invalid command!");
                            }
                        }
                        else{
                            throw new NoSuchElementException("Missing data for depositing an account.");
                        }
                        
                    }
                    else if(commands[0].equals("W")) {
                        if(commands.length == 6){
                            //Work in progress
                            Calendar today = Calendar.getInstance();
                            Date tempD = new Date(commands[4]);
                            Date tempTD = new Date((today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DAY_OF_MONTH) + "/" + today.get(Calendar.YEAR));
                            if (tempD.compareTo(tempTD) > 0 || tempD.compareTo(tempTD) == 0) {
                                throw new InputMismatchException("DOB invalid: " + commands[4] + " cannot be today or a future day.");
                            }
                            if (!tempD.isValid()) {
                                throw new InputMismatchException("DOB invalid: " + commands[4] + " not a valid calendar date!");
                            }
                            if (!tempD.underAge()) {
                                throw new InputMismatchException("DOB invalid: " + commands[4] + " under 16.");
                            }
                            double withdraw;
                            try {
                                withdraw = Double.parseDouble(commands[5]);
                            } catch (NumberFormatException e) {
                                throw new NumberFormatException("Not a valid amount.");
                            }
                            if (withdraw < 1) {
                                throw new InputMismatchException("Withdraw - amount cannot be 0 or negative.");
                            }
                            Profile tempP = new Profile(commands[2], commands[3], commands[4]);
                            if(commands[1].equals("C")){
                                Checking tempC = new Checking(tempP, withdraw);
                                if(activeDatabase.contains(tempC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "is not in the database.");
                                }
                                else{
                                    boolean result = activeDatabase.withdraw(tempC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + (result? "Withdraw - balance updated.": "Withdraw - insufficient fund."));
                                }
                            }
                            else if(commands[1].equals("MM")){
                                MoneyMarket tempC = new MoneyMarket(tempP, withdraw, 0);
                                if(activeDatabase.contains(tempC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + "is not in the database.");
                                }
                                else{
                                    boolean result = activeDatabase.withdraw(tempC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + (result? "Withdraw - balance updated.": "Withdraw - insufficient fund."));
                                }
                            }
                            else if(commands[1].equals("CC")){
                                if(tempD.overAge()){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is not in the database.");
                                }
                                CollegeChecking tempCC = new CollegeChecking(tempP, withdraw, Campus.NEW_BRUNSWICK);
                                if(activeDatabase.contains(tempCC) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is not in the database.");
                                }
                                else{
                                    boolean result = activeDatabase.withdraw(tempCC);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + (result? "Withdraw - balance updated.": "Withdraw - insufficient fund."));
                                }
                            }
                            else if(commands[1].equals("S")){
                                Savings tempS = new Savings(tempP, withdraw, 1);
                                if(activeDatabase.contains(tempS) == false){
                                    throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "is not in the database.");
                                }
                                else{
                                    boolean result = activeDatabase.withdraw(tempS);
                                    System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + (result? "Withdraw - balance updated.": "Withdraw - insufficient fund."));
                                }
                            }
                            else{
                                throw new NullPointerException("Invalid command!");
                            }
                        }
                        else{
                            throw new NoSuchElementException("Missing data for withdrawing an account.");
                        }
                        
                    }
                    else if(commands[0].equals("O")){
                        if((commands.length == 6 || commands.length == 7)){
                            Calendar today = Calendar.getInstance();
                            Date tempD = new Date(commands[4]);
                            Date tempTD = new Date((today.get(Calendar.MONTH)+1)+ "/" + today.get(Calendar.DAY_OF_MONTH) + "/" + today.get(Calendar.YEAR));
                            if(tempD.compareTo(tempTD) == 1 || tempD.compareTo(tempTD) == 0){
                                throw new InputMismatchException("DOB invalid: "+ commands[4] + " cannot be today or a future day.");
                            }
                            if(!tempD.isValid()){
                                throw new InputMismatchException("DOB invalid: "+ commands[4] + " not a valid calendar date!");
                            }
                            if(!tempD.underAge()){
                                throw new InputMismatchException("DOB invalid: "+ commands[4] + " under 16.");
                            }
                            double deposit;
                            try{
                                deposit = Double.parseDouble(commands[5]);
                            }
                            catch(NumberFormatException e) {
                                throw new NumberFormatException("Not a valid amount.");
                            }
                            if(deposit < 1){
                                throw new InputMismatchException("Initial deposit cannot be 0 or negative.");
                            }
                            if(commands.length == 6){
                                Profile tempP = new Profile(commands[2], commands[3], commands[4]);
                                if(commands[1].equals("C")){
                                    Checking tempC = new Checking(tempP, deposit);
                                    if(activeDatabase.contains(tempC)){
                                        throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "is already in the database.");
                                    }
                                    else{
                                        activeDatabase.open(tempC);
                                        System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(C) " + "opened.");
                                    }
                                }
                                else if(commands[1].equals("MM")){
                                    if(deposit < 2000){
                                        throw new InputMismatchException("Minimum of $2000 to open a Money Market account.");
                                    }
                                    MoneyMarket tempC = new MoneyMarket(tempP, deposit, 0);
                                    if(activeDatabase.contains(tempC)){
                                        throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "is already in the database.");
                                    }
                                    else{
                                        activeDatabase.open(tempC);
                                        System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(MM) " + "opened.");
                                    }
                                }
                                else{
                                    throw new NullPointerException("Invalid command!");
                                }
                            }
                            if(commands.length == 7){
                                Profile tempP = new Profile(commands[2], commands[3], commands[4]);
                                if(commands[1].equals("CC")){
                                    if(tempD.overAge()){
                                        throw new InputMismatchException("DOB invalid: "+ commands[4] + " over 24.");
                                    }
                                    CollegeChecking tempCC = null;
                                    if(Integer.parseInt(commands[6]) == 0){
                                        tempCC = new CollegeChecking(tempP, deposit, Campus.NEW_BRUNSWICK);
                                    }
                                    else if(Integer.parseInt(commands[6]) == 1){
                                        tempCC = new CollegeChecking(tempP, deposit, Campus.NEWARK);
                                    }
                                    else if(Integer.parseInt(commands[6]) == 2){
                                        tempCC = new CollegeChecking(tempP, deposit, Campus.CAMDEN);
                                    }
                                    else{
                                        throw new InputMismatchException("Invalid campus code.");
                                    }
                                    if(activeDatabase.contains(tempCC)){
                                        throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is already in the database.");
                                    }
                                    else if(activeDatabase.contains(tempCC)){
                                        throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "is already in the database.");
                                    }
                                    else{
                                        activeDatabase.open(tempCC);
                                        System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(CC) " + "opened.");
                                    }
                                }
                                else if(commands[1].equals("S")){
                                    Savings tempS = new Savings(tempP, deposit, Integer.parseInt(commands[6]));
                                    if(activeDatabase.contains(tempS)){
                                        throw new InputMismatchException(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "is already in the database.");
                                    }
                                    else{
                                        activeDatabase.open(tempS);
                                        System.out.println(commands[2] + " " + commands[3] + " " + commands[4] + "(S) " + "opened.");
                                    }
                                }
                                else{
                                    throw new NullPointerException("Invalid command!");
                                }
                            }
                        }
                        else{
                            throw new NoSuchElementException("Missing data for opening an account.");
                        }

                        // System.out.println(newEvent);
                        //nvm boolean result = activeDatabase.add();
                        // System.out.println(activeCalendar.add(newEvent));

                        // activeCalendar.print();
                        // System.out.println(result? "Event added to the calendar." : "John Doe 2/19/2000(C) is already in the database.");
                    }
                    else{
                        if(!textCommand.equals("")){
                            System.out.println("Invalid command!");
                        }
                    }
                }
                catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
