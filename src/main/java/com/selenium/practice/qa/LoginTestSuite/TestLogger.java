package com.selenium.practice.qa.LoginTestSuite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLogger {

    private static final String LOG_FILE = "src/main/java/com/selenium/practice/qa/LoginTestSuite/login_test_report.txt";

    public static void log(LoginData data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            StringBuilder logEntry = new StringBuilder();
            logEntry.append(data.toString())
                    .append("@")
                    .append(timestamp);
            writer.write(logEntry.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Logging failed for " + data.getId() + ": " + e.getMessage());
        }
    }
}
