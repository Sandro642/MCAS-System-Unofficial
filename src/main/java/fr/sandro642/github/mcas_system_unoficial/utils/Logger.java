package fr.sandro642.github.mcas_system_unoficial.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE = "logs/application.log";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static boolean logToFile = true; // Toggle to enable/disable file logging

    public enum Level {
        INFO, WARNING, ERROR, DEBUG
    }

    private Logger() {
        // Prevent instantiation
    }

    public static void log(Level level, String message) {
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String formattedMessage = String.format("[%s] [%s] %s", timestamp, level, message);

        // Print to console
        System.out.println(formattedMessage);

        // Optionally write to file
        if (logToFile) {
            writeToFile(formattedMessage);
        }
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void warning(String message) {
        log(Level.WARNING, message);
    }

    public static void error(String message) {
        log(Level.ERROR, message);
    }

    public static void debug(String message) {
        log(Level.DEBUG, message);
    }

    private static void writeToFile(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to write to log file: " + e.getMessage());
        }
    }
}

