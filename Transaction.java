//package bank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a transaction record.
 * This class allows for logging messages related to transactions and writing them to a file.
 * 
 * <p>
 * This class provides methods to add log messages, retrieve them, and persist them to a log file.
 * </p>
 *
 * @author Karina Lopez Silerio
 * @author Angel Ramses Salazar Portillo
 * @author Gresham Maese
 */
public class Transaction {
    /** A list of log messages related to transactions */
    private static List<String> logMessages = new ArrayList<>();

    /**
     * Constructor for the Transaction class.
     * Initializes an empty list for log messages.
     */
    public Transaction() {
    }

    /**
     * Adds a log message to the transaction record.
     *
     * @param message the log message to be added
     */
    public static void addLog(String message) {
        logMessages.add(message);
    }
    
    /**
     * Retrieves the list of log messages.
     *
     * @return a list of log messages
     */
    public static List<String> getLogMessages() {
        return logMessages;
    }

    /**
     * Writes all log messages to a file.
     * <p>
     * Appends to the file "transaction.log.txt" if it exists, otherwise creates a new file.
     * This method handles IO exceptions that may occur during the file writing process.
     * </p>
     */
    public static void writeLogsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("transaction.log.txt", true))) {
            for (String log : logMessages) {
                writer.println(log);
            }
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
