package com.selenium.practice.basics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {
    public static void main(String[] args) {
        //Reading in a file
        String filePath = "C:\\Users\\Admin\\Documents\\Project\\SeleniumPractice\\SeleniumPractice\\src\\main\\java\\com\\selenium\\practice\\basics\\sample.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
