package com.selenium.practice.collections;

public class ExceptionDemo {
    public static void main(String[] args) {
        //Try-catch
        try {
            int result = 10 / 0;
            System.out.println("Result: "+ result);
        }catch(ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program continues...");

        //Multiple Catch Blocks
        try {
            int[] numbers = {1,2,3};
            System.out.println(numbers[5]);
        } catch (ArithmeticException e) {
            System.out.println("Math error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index error: " + e.getMessage());
        }

        //Finally Block
        try {
            int value = 100 /2;
        } catch (Exception e) {
            System.out.println("Error occurred");
        } finally {
            System.out.println("This always runs, even if there's an exception.");
        }
    }

    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Must be 18 or older.");
        }
        System.out.println("Access granted");
    }
}
