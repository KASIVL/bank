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
 * Class representing a savings account, extending the Account class.
 * A savings account has limitations on the number of withdrawals that can be made.
 * 
 * <p>
 * This class manages the state of a savings account, including tracking
 * the number of withdrawals allowed and enforcing limits on withdrawals.
 * </p>
 *
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Saving extends Account {
    /** The maximum number of withdrawals allowed per period */
    private int maxNumberOfWithdraws;

    /** The number of withdrawals remaining in the current period */
    private int withdrawsLeft;

    /**
     * Constructor for the Saving class.
     *
     * @param savingsAccountNumber the account number for the savings account
     * @param savingsBalance the initial balance of the savings account
     * @param maxNumberOfWithdraws the maximum number of withdrawals allowed
     * @param accountHolder the name of the account holder
     */
    public Saving(int savingsAccountNumber, double savingsBalance, int maxNumberOfWithdraws, String accountHolder) {
        super(savingsAccountNumber, savingsBalance, accountHolder);
        this.maxNumberOfWithdraws = maxNumberOfWithdraws;
        this.withdrawsLeft = maxNumberOfWithdraws;
    }

    /**
     * Resets the number of withdrawals left at the start of a new period.
     * This method should be called to refresh the withdrawal limit.
     */
    public void resetWithdraws() {
        this.withdrawsLeft = maxNumberOfWithdraws; // Reset withdrawals left
    }
    
    /**
     * Retrieves the number of withdrawals left in the current period.
     *
     * @return the number of withdrawals left
     */
    public int getWithdrawsLeft() {
        return withdrawsLeft;
    }

    /**
     * Retrieves the maximum number of withdrawals allowed for the account.
     *
     * @return the maximum number of withdrawals
     */
    public int getMaxNumberOfWithdraws() {
        return maxNumberOfWithdraws;
    }

    /**
     * Overrides the withdraw method to enforce withdrawal limits.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is successful; false otherwise
     * 
     * <p>
     * This method checks if the withdrawal limit has been reached
     * and whether the account has sufficient funds before processing.
     * It logs the transaction result accordingly.
     * </p>
     */
    @Override
    public boolean withdraw(double amount) {
        if (withdrawsLeft > 0 && super.withdraw(amount)) {
            withdrawsLeft--;
            String logMessage = String.format("Withdrawal of $%.2f made successfully from account %s.", amount, getAccountNumber());
            Transaction.addLog(logMessage);
            return true;
        }
        String failureMessage = String.format("Withdrawal failed: Exceeds available balance or invalid amount from account %s.", getAccountNumber());
        Transaction.addLog(failureMessage);
        return false;
    }
}
