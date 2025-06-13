package com.selenium.practice.qa.TestCaseResults;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class TestCaseResultReader {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/selenium/practice/qa/TestCaseResults/test_results.txt";
        String summaryReportFilePath = "src/main/java/com/selenium/practice/qa/TestCaseResults/summary_report.txt";
        String errorLogFilePath = "src/main/java/com/selenium/practice/qa/TestCaseResults/error_log.txt";

        ArrayList<TestCaseResult> results = new ArrayList<TestCaseResult>();
        int passed = 0;
        int failed = 0;

        try(
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorLogFilePath))
        ){
            String line;
            while((line = br.readLine()) != null) {
                try {
                    String[] tokens = line.split(",");
                    if(tokens.length != 3) {
                        throw new InvalidTestResultException("Incomplete Test Result: " + line);
                    }
                    TestCaseResult testCaseResult = new TestCaseResult(tokens[0],tokens[1],tokens[2]);
                    results.add(testCaseResult);
                } catch (InvalidTestResultException e) {
                    errorWriter.write("Invalid line: " + line + " => " + e.getMessage());
                    errorWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        for(TestCaseResult result : results) {
            if(result.getResult().equalsIgnoreCase("PASS")) {
                passed++;
            }else if(result.getResult().equalsIgnoreCase("FAIL")) {
                failed++;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(summaryReportFilePath))) {
            bw.write("Total Test Cases: " + results.size());
            bw.write("\nPassed: " + passed);
            bw.write("\nFailed: " + failed);
        }catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
