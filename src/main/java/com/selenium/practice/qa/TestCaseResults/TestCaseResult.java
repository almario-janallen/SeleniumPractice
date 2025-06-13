package com.selenium.practice.qa.TestCaseResults;

public class TestCaseResult {
    String id;
    String name;
    String result;

    public TestCaseResult(String id, String name, String result) throws InvalidTestResultException{
        this.id = id;
        this.name = name;
        setResult(result);
    }

    public void setResult(String result) throws InvalidTestResultException {
        if(!result.equalsIgnoreCase("PASS") &&
           !result.equalsIgnoreCase("FAIL")) {
            throw new InvalidTestResultException("Invalid Result: " + result);
        }
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void displayTestCaseResult() {
        System.out.println("ID: " + id + " Name: " + name + " Result: " + result);
    }
}
