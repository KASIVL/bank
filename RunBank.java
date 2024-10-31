//package bank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;


/**
 * The RunBank class manages the bank application, including loading customer data,
 * displaying user menus, and handling various banking operations.
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class RunBank {
    // Use a LinkedHashMap to store users in alphabetical order hence TreeMap
    private static Map<String, Customer> alphaCustomers = new TreeMap<>();

    static String name = "";

    // Getter method to access the map if needed
    /**
     * Gets the map of customers stored in alphabetical order.
     * 
     * @return A map of customer names to Customer objects.
     */
    public static Map<String, Customer> getAlphaCustomers() {
        return alphaCustomers;
    }
    /**
     * The main method that initiates the banking application.
     * It loads customers from the specified CSV file and displays the main menu.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Klopez26\\Desktop\\CS 3331\\Project 1\\Project1\\src\\CS 3331 - Bank Users.csv";
        File file = new File(fileName);

        try {
            Scanner userScanner = new Scanner(file);

            // Assuming the first line is the header and we want to skip it
            if (userScanner.hasNextLine()) {
                String header = userScanner.nextLine();
            }

            while (userScanner.hasNextLine()) {
                String line = userScanner.nextLine();
                String[] fields = line.split(",");

                // Ensure there are enough fields to prevent ArrayIndexOutOfBoundsException
                
                if (fields.length < 15) {
                    System.err.println("Insufficient data in line ");
                    continue; // Skip this line
                }

                int id = Integer.parseInt(fields[0]);
                String firstName = fields[1];
                String lastName = fields[2];
                String dateOfBirth = fields[3];
                String address = (fields[4] + "," + fields[5] + "," + fields[6]); // Concatenate the entire address;
                String phoneNumber = fields[7];
                int checkingAccountNum = Integer.parseInt(fields[8]);
                double checkingBalance = Double.parseDouble(fields[9]);
                int savingsAccountNum = Integer.parseInt(fields[10]);
                double savingsBalance = Double.parseDouble(fields[11]);
                int creditAccountNum = Integer.parseInt(fields[12]);
                double creditMax = Double.parseDouble(fields[13]);
                double creditBalance = Double.parseDouble(fields[14]); 

                Customer customer = new Customer(id, 
                                                firstName, 
                                                lastName, 
                                                dateOfBirth, 
                                                address, 
                                                phoneNumber, 
                                                checkingAccountNum,
                                                checkingBalance,
                                                savingsAccountNum,
                                                savingsBalance,
                                                creditAccountNum,
                                                creditMax,
                                                creditBalance);

                // Add the lastName, firstName as key in the map
                alphaCustomers.put(lastName + "," + firstName, customer);
            }
            userScanner.close();

        } catch (FileNotFoundException e) { // Fixed typo in exception name
            System.out.println("File not found: " + fileName);
        }
        Scanner keyboardScanner = new Scanner(System.in);
        String  userScanner = "";
        do{
        display(alphaCustomers);
        System.out.println("Do you want to re-open the menu: Y.yes   N.no");
        userScanner = keyboardScanner.nextLine();
        }while(userScanner.equals("Y"));
        try {
            updateCSV(alphaCustomers);
        } catch (IOException e) {
            System.out.println("Error updating CSV: " + e.getMessage());
        }
        Transaction.writeLogsToFile();
    }

    /**
     * Updates the customer data in the CSV file.
     *
     * @param alphaCustomer The map of customers to be saved.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void updateCSV(Map<String, Customer> alphaCustomer) throws IOException{
        String csvFile = "CS 3331 - Bank Users.csv";
        try (FileWriter writer = new FileWriter(csvFile)){
            writer.append("Identification Number,First Name,Last Name,Data of Birth,Address,Phone Number,"
             + "Checking Account Number,Checking Starting Balance,Savings Account Number,Saving Starting Balance,Credit Account Number,Credit Max, Credit Starting Balance\n");

             for (Customer customer : alphaCustomer.values()){
                writer.append(String.valueOf(customer.getCustomerId())).append(",")
                      .append(customer.getPersonFirstName()).append(",")
                      .append(customer.getPersonLastName()).append(",")
                      .append(customer.getPersonBirthday()).append(",")
                      .append(customer.getPersonAddress()).append(",")
                      .append(customer.getPersonPhone()).append(",")
                      .append(String.valueOf(customer.getCheckingAccount().getAccountNumber())).append(",")
                      .append(String.valueOf(customer.getCheckingAccount().getBalance())).append(",")
                      .append(String.valueOf(customer.getSavingsAccount().getAccountNumber())).append(",")
                      .append(String.valueOf(customer.getSavingsAccount().getBalance())).append(",")
                      .append(String.valueOf(customer.getCreditAccount().getAccountNumber())).append(",")
                      .append(String.valueOf(customer.getCreditAccount().getCreditLimit())).append(",")
                      .append(String.valueOf(customer.getCreditAccount().getBalance())).append("\n");
             }
             writer.flush();
        }catch (IOException e) {
            System.out.println("Error updating CSV: " + e.getMessage());
        }
    }   

    /**
     * Displays the menu for different user roles and manages their corresponding actions.
     * The method prompts the user to identify themselves as a Manager, Employee, or Customer
     * and takes actions based on their selection.
     *
     * @param dataBase a map containing customer data where the key is a String (customer's name)
     *                 and the value is a Customer object representing the customer.
     */
    public static void display(Map<String, Customer> dataBase){
        System.out.println("Are you a (1)Manager, (2)Employee, or (3)Customer?");
        Scanner keyboardScanner = new Scanner(System.in);
        //Check .string on scanner///////////////////////////////////////////////////////////
        String userScanner = keyboardScanner.nextLine();
        switch (userScanner) {
            
            case "1": //manager
                System.out.println("1. Inquire account by name.");
                System.out.println("2. Inquire account by type/number.");
                //user input
                userScanner = keyboardScanner.nextLine();
                switch (userScanner) {
                    case "1":
                        System.out.println("Whose account would you like to inquire about?");
                        userScanner = keyboardScanner.nextLine();
                        break;
                        
                    case "2":
                        System.out.println("What is the account type?");
                        userScanner = keyboardScanner.nextLine();
                        break;

                    default:
                        break;
                }
                break;
                
            case "2": //employee
                System.out.println("1. Inquire account by name.");
                System.out.println("2. Inquire account by type/number.");
                System.out.println("3. Check Schedule");
                System.out.println("4. View Customer Requests");
                userScanner = keyboardScanner.nextLine();
                switch(userScanner){
                    
                }
                break;

            case "3": //costumer
                System.out.println("Please enter your name (Lastname,FirstName)");
                name = keyboardScanner.nextLine();
                customerActions(dataBase.get(name));
                break;

            default:
                break;
        }
    }

    /**
     * Manages customer actions such as balance inquiry, deposit, withdrawal, and transfer.
     *
     * @param customer The Customer object representing the current customer.
     */        
    private static void customerActions(Customer customer) {
        System.out.println("1. Inquire about a balance.");
        System.out.println("2. Deposit money to an account.");
        System.out.println("3. Withdraw money from an account.");
        System.out.println("4. Transfer money between accounts.");
        System.out.println("To exit enter any other button.");
        //added variables
        String moneyAmount = "0";
        Scanner Scanner = new Scanner(System.in);
        String userScanner = Scanner.nextLine();
        switch (userScanner) { // 1
            case "1":
                System.out.println("1. Inquire account by name.");
                System.out.println("2. Inquire account by type/number.");
                System.out.println("To exit enter any other button");
                userScanner = Scanner.nextLine();
                // user input
                switch (userScanner) { // 2
                    case "1":
                        System.out.println("Whose account would you like to inquire about?");
                        userScanner = Scanner.nextLine();
                        while(!alphaCustomers.containsKey(userScanner)){
                            System.out.println("Try again");
                            userScanner = Scanner.nextLine();
                        }
                        // user input
                        // display account information
                        System.out.println("Checkings balance: "+(alphaCustomers.get(userScanner)).getCheckingAccount().checkBalance());//this return checking balance
                        System.out.println("Savings balance: "+(alphaCustomers.get(userScanner)).getSavingsAccount().checkBalance());//this return savings balance
                        System.out.println("Credit balances: "+(alphaCustomers.get(userScanner)).getCreditAccount().checkBalance());//this return crredit balance
                        break; // Break for "A"

                    case "2":
                        System.out.println("What is the account type?");
                        System.out.println("1. Checkings");
                        System.out.println("2. Savings");
                        System.out.println("3. Credit");
                        System.out.println("To exit enter any other button");
                        userScanner = Scanner.nextLine();
                        // user input
                        switch (userScanner) { // 3
                            case "1":
                                // call the checkings class
                                do{
                                    System.out.println("What is the account number?");
                                    userScanner = Scanner.nextLine();
                                        if(Integer.parseInt(userScanner) == (alphaCustomers.get(userScanner)).getCheckingAccount().checkBalance()){
                                            System.out.println("Checkings balance: "+(alphaCustomers.get(userScanner)).getCheckingAccount().checkBalance());//this return checking balance
                                        }
                                        if(!alphaCustomers.containsKey(userScanner)){
                                            System.out.println("Incorrect input please enter againt: ");
                                        }
                                }while((!alphaCustomers.containsKey(userScanner)));
                                break;

                            case "2":
                                do{
                                    System.out.println("What is the account number?");
                                    userScanner = Scanner.nextLine();
                                        if(Integer.parseInt(userScanner) == (alphaCustomers.get(userScanner)).getSavingsAccount().checkBalance()){
                                            System.out.println("Savings balance: "+(alphaCustomers.get(userScanner)).getSavingsAccount().checkBalance());//this return savings balance
                                        }
                                        if(!alphaCustomers.containsKey(userScanner)){
                                                System.out.println("Incorrect input please enter againt: ");
                                        }
                                }while((!alphaCustomers.containsKey(userScanner)));
                                break;

                            case "3":
                                do{
                                    System.out.println("What is the account number?");
                                    userScanner = Scanner.nextLine();
                                    if(Integer.parseInt(userScanner) == (alphaCustomers.get(userScanner)).getCreditAccount().checkBalance()){
                                        System.out.println("Credit balance: "+(alphaCustomers.get(userScanner)).getCreditAccount().checkBalance());//this return credit balance
                                    }
                                    if(!alphaCustomers.containsKey(userScanner)){
                                        System.out.println("Incorrect input please enter againt: ");
                                    }
                                }while((!alphaCustomers.containsKey(userScanner)));
                                break;

                            default:
                                return;
                                //break;
                        }

                        break; // Break for "B"

                    default: // 2
                        //return;
                        break;
                }
                break; // Break for "a"

            case "2": // deposit to an account
                System.out.println("Select: 1. Checkings, 2. Savings, 3. Credit");
                System.out.println("To exit enter any other button");
                userScanner = Scanner.nextLine();
                switch (userScanner) {
                    case "1": // Checking
                        System.out.println("How much would you like to deposit?");
                        userScanner = Scanner.nextLine();
                        customer.getCheckingAccount().deposit(Double.parseDouble(userScanner));
                        System.out.println("Succesfull deposit");
                        // handle deposit
                        break;

                    case "2": // Saving
                        System.out.println("How much would you like to deposit?");
                        userScanner = Scanner.nextLine();
                        customer.getSavingsAccount().deposit(Double.parseDouble(userScanner));
                        System.out.println("Succesfull deposit");
                        break;

                    case "3": // Credit
                        System.out.println("How much would you like to deposit?");
                        userScanner = Scanner.nextLine();
                        customer.getCreditAccount().deposit(Double.parseDouble(userScanner));
                        System.out.println("Succesfull deposit");
                        break;

                    default: // exit
                        //return;
                        break;
                }
                break;

            case "3": // withdraw from account
                System.out.println("Select: 1. Checkings, 2. Savings, 3. Credit");
                userScanner = Scanner.nextLine();
                switch (userScanner) {
                    case "1": // Checking
                        System.out.println("How much would you like to withdraw?");
                        userScanner = Scanner.nextLine();
                        customer.getCheckingAccount().withdraw(Double.parseDouble(userScanner));
                        System.out.println("Successfull withdraw");
                        // handle withdraw
                        break;

                    case "2": // Saving
                        System.out.println("How much would you like to withdraw?");
                        userScanner = Scanner.nextLine();
                        customer.getSavingsAccount().withdraw(Double.parseDouble(userScanner));
                        System.out.println("Successfull withdraw");
                        break;

                    case "3": // Credit
                        System.out.println("How much would you like to withdraw?");
                        userScanner = Scanner.nextLine();
                        if(customer.getCreditAccount().withdraw(Double.parseDouble(userScanner))){
                            System.out.println("Successfull withdraw");
                        }
                        break;

                    default: // exit
                        // handle invalid input
                        break;
                }
                break;
                

            case "4": // transfer to account
                System.out.println("To who would you like to transfer");
                System.out.println("Please enter as Lastname,Firstname");
                do{
                userScanner = Scanner.nextLine();
                if(!alphaCustomers.containsKey(userScanner)){
                    System.out.println("Wrong input please enter again: ");
                }
                }while((!alphaCustomers.containsKey(userScanner)));
                System.out.println("Please enter the amount on money you whant to transfer");
                moneyAmount = Scanner.nextLine();
                do{
                    if(customer.getCheckingAccount().transferMoney(alphaCustomers,Double.parseDouble(moneyAmount),name,userScanner)){
                        System.out.println("The transfer to "+userScanner+" was succesfull");
                        break;
                    }
                    System.out.println("The amount of money ecceds your balance please try agin, enter the amount on money you whant to transfer");
                    System.out.println("To EXIT enter 'exit'");
                    moneyAmount = Scanner.nextLine();
                    if(moneyAmount.equals("exit")){
                        break;
                    }

                }while(true);
                break;

            default:
                break;
        }
    }
}