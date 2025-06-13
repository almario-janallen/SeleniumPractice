package com.selenium.practice.basics;/*
Write code that:
    Declares and prints all basic data types
    Uses arithmetic and logical operators
    Demonstrates type casting (e.g., int → double and double → int)
    Concatenates strings
 */


public class JavaBasicDemo {
    public static void main(String[] args) {
        /*
        Variables and Data Types:
        Primitive data types
            int - whole numbers
            double - default decimal numbers (precision: ~15-16 decimal places && size: 64bits)
            float - decimal numbers (precision: ~6-7 decimal places && size: 32bits) -- needs suffix f
            char - single character
            boolean - true or false
            byte - very small number
            short - small integers
            long - large whole numbers
        Objects (has methods in it)
            String
            Scanner
            ArrayList
         */

        int age = 25;
        double height = 5.8;
        float pi = 3.14f; //needs a suffix f to declare it as float and not a double. Compilation error if no suffix
        char grade = 'A';
        boolean isPassed = true;
        long bigNum = 1234567890L; // Note the L suffix
        short smallNum = 32000;


        String name = "Allen";
        System.out.println("Name: " + name);
        System.out.println("Name in Uppercase: " +name.toUpperCase()); //display usage of method

        //Operators
        int num1 = 10, num2 = 3;
        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 / num2 = " + ((double) num1 / num2));
        System.out.println("Logical AND (num2 > 2 && num2 < 5): " + (num2 > 2 && num2 < 5));


        /*
        Type casting
            Implicit - assign from smaller type to a larger type. No precision is lost
            Explicit - assign from larger type to a smaller type.
        */

        //implicit casting
        double converted = age;
        System.out.println("Implicit Casting of variable age");
        System.out.println("int value: " + age);
        System.out.println("double value: " + converted);

        //explicit casting
        int rounded = (int) height;
        System.out.println("Explicit casting of variable height");
        System.out.println("double value: " + height);
        System.out.println("int value: " + rounded);


        //practice
        int a = 100;
        double b = a; // implicit casting

        double c = 9.99;
        int d = (int)c; // ⚠️ error: needs explicit casting -- original: int d = c;

        char letter = 66; // implicit from int to char
        int ascii = 'A';  // implicit from char to int

        System.out.println("Value of b: " + b);
        System.out.println("Value of d: " + d);
        System.out.println("Letter: " + letter);
        System.out.println("ASCII of 'A': " + ascii);
    }
}
