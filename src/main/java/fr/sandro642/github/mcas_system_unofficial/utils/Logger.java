package fr.sandro642.github.mcas_system_unofficial.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Sandro642
 * @version 1.0
 * @project MCAS System
 * @since 2024
 * @description The Maneuvering Characteristics Augmentation System (MCAS) is an automated system designed to enhance the flight characteristics of an aircraft, particularly regarding its behavior at high angles of attack. This system plays a crucial role in the stability of the aircraft during certain maneuvers, especially when an aircraft is at low speed or climbing, and helps to prevent a stall.
 *
 * @see <a href="https://fr.wikipedia.org/wiki/Maneuvering_Characteristics_Augmentation_System">Maneuvering Characteristics Augmentation System</a>
 *
 * @license <a href="https://opensource.org/licenses/MIT">MIT License</a>
 */

public class Logger {

    /**
     * @method LogLevel
     * @description Log a message
     *
     * @type INFO, WARNING, ERROR, DEBUG, CRITICAL, FATAL, TRACE, SUCCESS
     */
    public enum LogLevel {
        INFO,
        WARNING,
        ERROR,
        DEBUG,
        CRITICAL,
        FATAL,
        TRACE,
        SUCCESS
    }

    /**
     * @property currentLevel
     * @description Current log level
     *
     * Current logging level (modifiable as needed)
     */
    private LogLevel currentLevel;

    public Logger(LogLevel level) {
        this.currentLevel = level;
    }

    /**
     * @method log
     * @description Log a message
     *
     * @param level LogLevel
     * @param message String
     * @return void
     */
    private void log(LogLevel level, String message) {
        if (level.ordinal() >= this.currentLevel.ordinal()) {
            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.println("[" + timeStamp + "] [" + level + "] " + message);
        }
    }

    /**
     * @method info
     * @description Log an info message
     *
     * @param message
     */
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    /**
     * @method warning
     * @description Log a warning message
     *
     * @param message
     */
    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    /**
     * @method error
     * @description Log an error message
     *
     * @param message
     */
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    /**
     * @method debug
     * @description Log a debug message
     *
     * @param message
     */
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    /**
     * @method critical
     * @description Log a critical message
     *
     * @param message
     */
    public void critical(String message) {
        log(LogLevel.CRITICAL, message);
    }

    /**
     * @method fatal
     * @description Log a fatal message
     *
     * @param message
     */
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    /**
     * @method trace
     * @description Log a trace message
     *
     * @param message
     */
    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    /**
     * @method success
     * @description Log a success message
     *
     * @param message
     */
    public void success(String message) {
        log(LogLevel.SUCCESS, message);
    }


    /**
     * @method setLogLevel
     * @description Set the log level
     *
     * @param level LogLevel
     * @return void
     */
    public void setLogLevel(LogLevel level) {
        this.currentLevel = level;
    }
}
