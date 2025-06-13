package com.selenium.practice.basics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/selenium/practice/basics/output.txt";
        String content = "This is a line of text written to the file";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.newLine();
            writer.write("Second line.");
            System.out.println("File written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
