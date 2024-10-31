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
 * Class representing a checking account, extending the Account class.
 * This class handles deposits, withdrawals, and money transfers, while logging transactions.
 * 
 * <p>This class allows for the management of checking account operations, 
 * providing functionality for transferring funds between accounts.</p>
 * 
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Checking extends Account {
    
    /**
     * Constructor for the Checking class.
     *
     * @param checkingAccountNumber the account number for the checking account
     * @param checkingBalance the initial balance of the checking account
     * @param accountHolder the name of the account holder
     */
    public Checking(int checkingAccountNumber, double checkingBalance, String accountHolder) {
        super(checkingAccountNumber, checkingBalance, accountHolder);
    }

    /**
     * Transfers money between two checking accounts.
     *
     * <p>This method checks the sender's account for sufficient funds and 
     * performs the transfer if possible. It logs the transaction details.</p>
     *
     * @param alphaCustomers a map of customers keyed by account number
     * @param amount the amount to transfer
     * @param accountFrom the account number of the sender
     * @param accountTo the account number of the recipient
     * @return true if the transfer is successful; false otherwise
     */
    public boolean transferMoney(Map<String, Customer> alphaCustomers, double amount, String accountFrom, String accountTo) {
        // Retrieve sender and recipient from TreeMap
        Customer sender = alphaCustomers.get(accountFrom);
        Customer recipient = alphaCustomers.get(accountTo);

        // Retrieve checking accounts
        Checking senderAccount = sender.getCheckingAccount();
        Checking recipientAccount = recipient.getCheckingAccount();

        if (senderAccount.withdraw(amount)) {
            recipientAccount.deposit(amount);
            String logMessage = String.format("%s, %s transferred $%.2f from account %s to %s, %s", 
                sender.getPersonLastName(), 
                sender.getPersonFirstName(),
                amount,
                accountFrom,
                recipient.getPersonLastName(), 
                recipient.getPersonFirstName());
            Transaction.addLog(logMessage);
            return true;
        } else {
            String failureMessage = String.format("Transfer failed: Insufficient funds in account %s", accountFrom);
            Transaction.addLog(failureMessage);
            return false;
        }
    }
}
