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

/**
 * Represents a customer in the banking system.
 * This class extends the Person class and includes attributes for
 * customer identification and associated bank accounts (checking, savings, and credit).
 * 
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Customer extends Person {
    // Customer attributes
    private int customerId;
    // Objects for accounts
    private Checking checkingAccount;
    private Saving savingsAccount;
    private Credit creditAccount;

    /**
     * Constructs a Customer with specified attributes and initializes the associated accounts.
     *
     * @param customerId the unique identifier for the customer
     * @param personFirstName the first name of the customer
     * @param personLastName the last name of the customer
     * @param personBirthday the birthday of the customer
     * @param personAddress the address of the customer
     * @param personPhone the phone number of the customer
     * @param checkingAccountNum the account number for the checking account
     * @param checkingBalance the initial balance for the checking account
     * @param savingsAccountNum the account number for the savings account
     * @param savingsBalance the initial balance for the savings account
     * @param creditAccountNum the account number for the credit account
     * @param creditMax the maximum credit limit for the credit account
     * @param creditBalance the initial balance for the credit account
     */
    public Customer(int customerId, 
                    String personFirstName, 
                    String personLastName,  
                    String personBirthday, 
                    String personAddress, 
                    String personPhone, 
                    int checkingAccountNum,
                    double checkingBalance,
                    int savingsAccountNum,
                    double savingsBalance,
                    int creditAccountNum,
                    double creditMax,
                    double creditBalance) {

        // Call on constructor in Person (the parent class) to set Person attributes
        super(personFirstName, personLastName, personBirthday, personAddress, personPhone);
        
        // Set Customer attributes
        this.customerId = customerId;

        String accountHolder = (personLastName + "," + personFirstName);

        // Create checking, saving, and credit objects with customer information
        this.checkingAccount = new Checking(checkingAccountNum, checkingBalance, accountHolder);
        this.savingsAccount = new Saving(savingsAccountNum, savingsBalance, 100, accountHolder);
        this.creditAccount = new Credit(creditAccountNum, creditBalance, 850, "11/01/24", (creditBalance < 0), creditMax, accountHolder);
    }

    // Getter and Setter for customerId
    /**
     * Retrieves the customer ID for this customer.
     *
     * @return the customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID for this customer.
     *
     * @param customerId the new customer ID to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getters for accounts
    /**
     * Retrieves the checking account associated with this customer.
     *
     * @return the checking account
     */
    public Checking getCheckingAccount() {
        return checkingAccount;
    }

    /**
     * Retrieves the savings account associated with this customer.
     *
     * @return the savings account
     */
    public Saving getSavingsAccount() {
        return savingsAccount;
    }

    /**
     * Retrieves the credit account associated with this customer.
     *
     * @return the credit account
     */
    public Credit getCreditAccount() {
        return creditAccount;
    }

    /**
     * Views the balance of the specified account.
     *
     * @param account the account for which to view the balance
     * @return the balance of the specified account, or 0.0 if the account is invalid
     */
    public double viewBalance(Account account) {
        if (account != null) {
            return account.getBalance(); // Assuming the Account class has a getBalance() method
        } else {
            //System.out.println("Invalid account. Unable to view balance.");
            return 0.0; // Return 0.0 or some indication of an error
        }
    }
}
