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
 * Class representing a Manager, extending the Employee class.
 * A manager has specific attributes such as title and salary.
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Manager extends Employee {
    /** The title of the manager (e.g., Senior Manager, Operations Manager) */
    private String managerTitle;

    /** The salary of the manager */
    private int managerSalary;

    /**
     * Constructor for the Manager class.
     *
     * @param id the identification number of the manager
     * @param firstName the first name of the manager
     * @param lastName the last name of the manager
     * @param dateOfBirth the date of birth of the manager
     * @param address the residential address of the manager
     * @param phoneNumber the phone number of the manager
     * @param checkingAccountNum the checking account number of the manager
     * @param checkingBalance the starting balance of the checking account
     * @param savingsAccountNum the savings account number of the manager
     * @param savingsBalance the starting balance of the savings account
     * @param creditAccountNum the credit account number of the manager
     * @param creditMax the maximum credit limit
     * @param creditBalance the starting balance of the credit account
     * @param managerTitle the title of the manager
     * @param managerSalary the salary of the manager
     */
    public Manager(String id, String firstName, String lastName, String dateOfBirth, String address, 
                   String phoneNumber, String checkingAccountNum, String checkingBalance, 
                   String savingsAccountNum, String savingsBalance, String creditAccountNum, 
                   String creditMax, String creditBalance, String managerTitle, int managerSalary) {
        super(id, firstName, lastName, dateOfBirth, address, phoneNumber, 
              checkingAccountNum, checkingBalance, savingsAccountNum, savingsBalance, 
              creditAccountNum, creditMax, creditBalance);
        this.managerTitle = managerTitle;
        this.managerSalary = managerSalary;
    }

    // Getters and Setters for Manager

    /**
     * Retrieves the title of the manager.
     *
     * @return the manager title
     */
    public String getManagerTitle() {
        return managerTitle;
    }

    /**
     * Sets the title of the manager.
     *
     * @param managerTitle the new manager title to set
     */
    public void setManagerTitle(String managerTitle) {
        this.managerTitle = managerTitle;
    }

    /**
     * Retrieves the salary of the manager.
     *
     * @return the manager salary
     */
    public int getManagerSalary() {
        return managerSalary;
    }

    /**
     * Sets the salary of the manager.
     *
     * @param managerSalary the new manager salary to set
     */
    public void setManagerSalary(int managerSalary) {
        this.managerSalary = managerSalary;
    }

    // Additional manager-specific methods can be added here if needed
}
