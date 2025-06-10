/*
Write a Java program that prints numbers from 1 to 20.
    Print "Fizz" if divisible by 3
    Print "Fuzz" if divisible by 5
    Print "FizzBuzz" if divisible by both 3 and 5
    Otherwise, print the number
 */

public class ConditionalStatements {
    public static void main(String[] args) {
        //if-else example
        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else {
            System.out.println("Grade: C or below");
        }

        //switch example
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Another day");
        }

        //for loop
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        //while loop
        int i = 1;
        while (i <= 5) {
            System.out.println("While loop count: " + i);
            i++;
        }

        //do-while loop
        int j = 1;
        do {
            System.out.println("Do-while count: " + j);
            j++;
        } while (j <= 5);

        //break and continue
        
        for (int k = 1; k <= 5; k++) {
            if (k == 3) continue; // skips 3
            if (k == 4) break;    // stops at 4
            System.out.println(k);
        }

        //Challenge
        System.out.println("\nUsing for loop");
        for (int l = 1; l <=20 ; l++){
            boolean isDivisibleBy3 = (l % 3 == 0);
            boolean isDivisibleBy5 = (l % 5 == 0);
            if (isDivisibleBy3 && isDivisibleBy5) {
                System.out.println("FizzBuzz");
            }
            else if (isDivisibleBy3){
                System.out.println("Fizz");
            }
            else if (isDivisibleBy5){
                System.out.println("Buzz");
            }
            else {
                System.out.println(l);
            }
        }

        System.out.println("\nUsing while loop");
        int m = 1;
        while (m <= 20) {
            boolean isDivisibleBy3 = (m % 3 == 0);
            boolean isDivisibleBy5 = (m % 5 == 0);
            if (isDivisibleBy3 && isDivisibleBy5) {
                System.out.println("FizzBuzz");
            }
            else if (isDivisibleBy3){
                System.out.println("Fizz");
            }
            else if (isDivisibleBy5){
                System.out.println("Buzz");
            }
            else {
                System.out.println(m);
            }
            m++;
        }
    }
}
