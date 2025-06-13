package com.selenium.practice.qa.TestCaseManager;

public class TestCase {
    String name, status;

    public TestCase(String name, String status) throws InvalidStatusException{
        this.name = name;
        setStatus(status);
    }

    public void setStatus(String status) throws InvalidStatusException{
        if(!status.equalsIgnoreCase("pass") &&
           !status.equalsIgnoreCase("fail") &&
           !status.equalsIgnoreCase("blocked")) {
            throw new InvalidStatusException("Invalid Status: "+ status);
        }
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Test Case: " + name + " | Status: " + status);
    }
}
