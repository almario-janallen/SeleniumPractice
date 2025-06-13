package com.selenium.practice.qa;
import java.util.ArrayList;

public class TestManager {
    ArrayList<TestCase> testCases = new ArrayList<>();

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void updateTestStatus(String name, String newStatus) throws TestCaseNotFoundException, InvalidStatusException {
        for (TestCase tc : testCases) {
            if (tc.getName().equalsIgnoreCase(name)) {
                tc.setStatus(newStatus);
                return;
            }
        }
        throw new TestCaseNotFoundException("Test case not found: " + name);
    }

    public void displayAll() {
        for (TestCase tc : testCases) {
            tc.display();
        }
    }
}
