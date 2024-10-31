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
 * Abstract class representing a person with personal details.
 * This class serves as a base for other classes that represent specific types of people, such as customers and employees.
 * 
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public abstract class Person {

    private String personFirstName;
    private String personLastName;
    private String personBirthday;
    private String personAddress;
    private String personPhone;

    /**
     * Constructor for the Person class.
     *
     * @param personFirstName the first name of the person
     * @param personLastName the last name of the person
     * @param personBirthday the birthday of the person
     * @param personAddress the address of the person
     * @param personPhone the phone number of the person
     */
    public Person(String personFirstName, String personLastName, String personBirthday, 
                  String personAddress, String personPhone) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.personBirthday = personBirthday;
        this.personAddress = personAddress;
        this.personPhone = personPhone;
    }

    // Getters and setters for the fields

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(String personBirthday) {
        this.personBirthday = personBirthday; // Consider adding validation
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone; // Consider adding validation
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + personFirstName + '\'' +
                ", lastName='" + personLastName + '\'' +
                ", birthday='" + personBirthday + '\'' +
                ", address='" + personAddress + '\'' +
                ", phone='" + personPhone + '\'' +
                '}';
    }
}
