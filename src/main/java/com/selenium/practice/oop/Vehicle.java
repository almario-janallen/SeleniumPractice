package com.selenium.practice.oop;

public class Vehicle {
    String brand;
    double speed;

    public Vehicle(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void drive(){
        System.out.printf("%s is moving.\n",this.brand);
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Speed: %.1f", this.brand, this.speed);
    }

}
