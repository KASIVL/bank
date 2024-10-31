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
 * Class representing an Employee, extending the Person class.
 * An employee has a title, salary, schedule, payroll type, and can manage customer requests.
 * 
 * <p>Employees can create and delete accounts, view their schedule, and manage customer requests.</p>
 * 
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Employee extends Person {

    /** The title of the employee (e.g., Manager, Engineer) */
    private String employeeTitle;

    /** The salary of the employee */
    private int employeeSalary;

    /** The work schedule of the employee, stored as a list of strings (e.g., "Monday 9-5") */
    private List<String> employeeSchedule;

    /** The employee's payroll type (e.g., hourly, salary) */
    private String payrollType;

    /** A list of customers with active requests for the employee to handle */
    private List<Customer> customerRequest;

    /** The account number is private for the employee */
    private int accountNumber;

    /**
     * Constructor for Employee class.
     *
     * @param id the identification number of the employee
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param dateOfBirth the date of birth of the employee
     * @param address the residential address of the employee
     * @param phoneNumber the phone number of the employee
     * @param checkingAccountNum the checking account number of the employee
     * @param checkingBalance the starting balance of the checking account
     * @param savingsAccountNum the savings account number of the employee
     * @param savingsBalance the starting balance of the savings account
     * @param creditAccountNum the credit account number of the employee
     * @param creditMax the maximum credit limit
     * @param creditBalance the starting balance of the credit account
     * @param employeeTitle the title of the employee
     * @param employeeSalary the salary of the employee
     * @param payrollType the payroll type of the employee
     * @param accountNumber the account number of the employee
     */
    public Employee(String id, String firstName, String lastName, String dateOfBirth, String address,
                    String phoneNumber, String checkingAccountNum, String checkingBalance,
                    String savingsAccountNum, String savingsBalance, String creditAccountNum,
                    String creditMax, String creditBalance, String employeeTitle, int employeeSalary,
                    String payrollType, int accountNumber) {
        super(id, firstName, lastName, dateOfBirth, address, phoneNumber, 
              checkingAccountNum, checkingBalance, savingsAccountNum, savingsBalance, 
              creditAccountNum, creditMax, creditBalance);
        this.employeeTitle = employeeTitle;
        this.employeeSalary = employeeSalary;
        this.payrollType = payrollType;
        this.accountNumber = accountNumber;
        this.employeeSchedule = new ArrayList<>(); // Initialize to avoid null pointer exception
        this.customerRequest = new ArrayList<>(); // Initialize to avoid null pointer exception
    }

    /**
     * Views the employee's schedule.
     *
     * @return the employee's schedule as a list of strings
     */
    public List<String> viewSchedule() {
        return employeeSchedule;
    }

    // Getters and setters for employee details

    /**
     * Retrieves the title of the employee.
     *
     * @return the employee title
     */
    public String getEmployeeTitle() {
        return employeeTitle;
    }

    /**
     * Sets the title of the employee.
     *
     * @param employeeTitle the new employee title to set
     */
    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    /**
     * Retrieves the salary of the employee.
     *
     * @return the employee salary
     */
    public int getEmployeeSalary() {
        return employeeSalary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param employeeSalary the new employee salary to set
     */
    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    /**
     * Retrieves the schedule of the employee.
     *
     * @return the employee schedule
     */
    public List<String> getEmployeeSchedule() {
        return employeeSchedule;
    }

    /**
     * Sets the schedule of the employee.
     *
     * @param employeeSchedule the new schedule to set
     */
    public void setEmployeeSchedule(List<String> employeeSchedule) {
        this.employeeSchedule = employeeSchedule;
    }

    /**
     * Retrieves the payroll type of the employee.
     *
     * @return the payroll type
     */
    public String getPayrollType() {
        return payrollType;
    }

    /**
     * Sets the payroll type of the employee.
     *
     * @param payrollType the new payroll type to set
     */
    public void setPayrollType(String payrollType) {
        this.payrollType = payrollType;
    }

    /**
     * Retrieves the list of customer requests assigned to the employee.
     *
     * @return the list of customer requests
     */
    public List<Customer> getCustomerRequest() {
        return customerRequest;
    }

    /**
     * Sets the list of customer requests for the employee.
     *
     * @param customerRequest the new list of customer requests to set
     */
    public void setCustomerRequest(List<Customer> customerRequest) {
        this.customerRequest = customerRequest;
    }

    /**
     * Retrieves the account number of the employee.
     *
     * @return the employee account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number of the employee.
     *
     * @param accountNumber the new account number to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Creates a new account for the employee.
     *
     * @return the newly created account
     */
    @Override
    public Account createAccount() {
        // Logic to create a new account for the employee
        Account newAccount = new Account(); // Assuming an Account class exists
        return newAccount;
    }

    /**
     * Deletes the specified account associated with the employee.
     *
     * @param account the account to delete
     */
    @Override
    public void deleteAccount(Account account) {
        // Logic to delete the specified account
        System.out.println("Account deleted for account number: " + accountNumber);
        logs.add(account.getPersonName() + " checked their balance in " + account.getAccountNumber());
    }
}
