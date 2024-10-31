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
 * Abstract class representing a generic bank account.
 * This class provides methods for basic account operations such as
 * depositing and withdrawing funds, as well as checking the account balance.
 * 
 * <p>This class serves as a base for specific types of accounts, providing 
 * shared attributes and methods.</p>
 * 
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public abstract class Account {
    protected int accountNumber;
    protected double balance;
    protected String accountHolder;

    /**
     * Constructs an Account with the specified account number, initial balance,
     * and account holder's name.
     *
     * @param accountNumber the unique identifier for the account
     * @param balance the initial balance of the account
     * @param accountHolder the name of the account holder
     */
    public Account(int accountNumber, double balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    /**
     * Retrieves the account number of this account.
     *
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Retrieves the current balance of this account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates the balance of this account to the specified amount.
     *
     * @param balance the new balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Deposits the specified amount into this account.
     *
     * <p>This method checks if the amount to deposit is positive. If valid, 
     * it adds the amount to the balance and logs the transaction.</p>
     *
     * @param amount the amount to deposit
     * @return true if the deposit was successful, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String logMessage = String.format("%s Deposit of $%.2f to account %s", 
                accountHolder, amount, accountNumber);
            Transaction.addLog(logMessage);
            return true;
        }
        String logMessage = String.format("%s Attempted deposit of invalid amount $%.2f to account %s", 
            accountHolder, amount, accountNumber);
        Transaction.addLog(logMessage);
        return false;
    }

    /**
     * Withdraws the specified amount from this account.
     *
     * <p>This method checks if the amount to withdraw is positive and does not 
     * exceed the current balance. If valid, it deducts the amount from the 
     * balance and logs the transaction.</p>
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String logMessage = String.format("%s Withdrawal of $%.2f from account %s", 
                accountHolder, amount, accountNumber);
            Transaction.addLog(logMessage);
            return true;
        }
        String logMessage = String.format("%s Attempted withdrawal of invalid amount $%.2f from account %s", 
            accountHolder, amount, accountNumber);
        Transaction.addLog(logMessage);
        return false;
    }

    /**
     * Checks the current balance of this account.
     * 
     * <p>This method logs the action of checking the balance and returns the 
     * current balance.</p>
     *
     * @return the current balance of the account
     */
    public double checkBalance() {
        double currentBalance = balance;
        String logMessage = String.format("%s checked their balance $%.2f", 
            accountHolder, currentBalance);
        Transaction.addLog(logMessage);
        return currentBalance;
    }
}