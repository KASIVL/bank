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
 * Represents a credit account, which is a type of bank account
 * that allows for borrowing against a credit limit.
 * This class extends the Account class and includes additional
 * properties and methods specific to credit accounts.
 * 
 * <p>Credit accounts manage a customer's ability to borrow funds 
 * within a set limit, tracking payments, credit scores, and due dates.</p>
 * 
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Credit extends Account {

    private double creditScore;
    private String dueDate;
    private boolean isInDebt; 
    private double creditLimit;

    /**
     * Constructs a Credit account with specified attributes.
     *
     * @param creditAccountNumber the unique identifier for the credit account
     * @param creditBalance the initial balance of the credit account
     * @param creditScore the credit score associated with the account
     * @param dueDate the due date for payments on the credit account
     * @param isInDebt whether the account is currently in debt
     * @param creditLimit the maximum amount that can be charged on the credit account
     * @param accountHolder the name of the account holder
     */
    public Credit(int creditAccountNumber, 
                  double creditBalance,
                  double creditScore,
                  String dueDate,
                  boolean isInDebt, 
                  double creditLimit,
                  String accountHolder) {
        super(creditAccountNumber, creditBalance, accountHolder);
        this.creditScore = creditScore;
        this.dueDate = dueDate;
        this.isInDebt = isInDebt;
        this.creditLimit = creditLimit;
    }

    // Getter for creditScore
    /**
     * Retrieves the credit score for this account.
     *
     * @return the credit score
     */
    public double getCreditScore() {
        return creditScore;
    }

    // Setter for creditScore
    /**
     * Sets the credit score for this account.
     *
     * @param creditScore the new credit score to set
     */
    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

    // Getter for dueDate
    /**
     * Retrieves the due date for this credit account.
     *
     * @return the due date as a String
     */
    public String getDueDate() {
        return dueDate;
    }

    // Setter for dueDate
    /**
     * Sets the due date for this credit account.
     *
     * @param dueDate the new due date to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // Getter for credit limit
    /**
     * Retrieves the credit limit for this account.
     *
     * @return the credit limit
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    // Method to check if the account is in debt
    /**
     * Checks if the account is currently in debt.
     *
     * @return true if the account balance is greater than 0; false otherwise
     */
    public boolean isInDebt() {
        return getBalance() > 0; // Check if the current balance is greater than 0
    }

    // Override deposit to make a payment against the credit account
    /**
     * Makes a payment against the credit account, reducing the amount owed.
     *
     * @param amount the payment amount
     * @return true if the payment was successful, false otherwise
     */
    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            double currentBalance = getBalance();
            currentBalance += amount; // Increase the balance by the deposit amount
    
            // Update the account balance
            setBalance(currentBalance); // Ensure to update the balance in the account
    
            // Log successful deposit
            String logMessage = String.format("Deposit of $%.2f made successfully to account %s.", amount, getAccountNumber());
            Transaction.addLog(logMessage);
            return true;
        }
        // Log failed payment attempt
        String failureMessage = "Payment failed: Amount must be greater than zero.";
        Transaction.addLog(failureMessage);
        return false;
    }

    // Override withdraw to charge to the credit account
    /**
     * Charges the specified amount to the credit account, increasing the amount owed.
     *
     * @param amount the charge amount
     * @return true if the charge was successful, false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= 0) {
            double currentBalance = getBalance();
            currentBalance -= amount; // Decrease the balance by the withdrawal amount
    
            // Update the account balance
            setBalance(currentBalance); // Ensure to update the balance in the account
    
            // Log successful withdrawal
            String logMessage = String.format("Withdrawal of $%.2f made successfully from account %s.", amount, getAccountNumber());
            Transaction.addLog(logMessage);
            return true;
        }
        // Log failed withdrawal attempt
        String failureMessage = String.format("Withdrawal failed: Exceeds available balance or invalid amount from account %s.", getAccountNumber());
        Transaction.addLog(failureMessage);
        return false;
    }
}
