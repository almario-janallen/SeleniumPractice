package com.selenium.practice.qa.TestCaseManager;

public class TestCaseDemo {
    public static void main(String[] args) {
        TestManager manager = new TestManager();
        try {
            TestCase tc1 = new TestCase("Login Test", "pass");
            TestCase tc2 = new TestCase("Signup Test", "fail");
            TestCase tc3 = new TestCase("Checkout Test", "blocked");

            manager.addTestCase(tc1);
            manager.addTestCase(tc2);
            manager.addTestCase(tc3);

            System.out.println("Initial Test Cases:");
            manager.displayAll();

            System.out.println("\nUpdating test status...");
            manager.updateTestStatus("Signup Test","pass");
            manager.updateTestStatus("Checkout Test","invalid");
        } catch(InvalidStatusException | TestCaseNotFoundException e) {
            System.out.println("\uFE0F Error: " + e.getMessage());
        }

        System.out.println("\nFinal Test Cases:");
        manager.displayAll();
    }
}
