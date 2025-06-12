package com.selenium.practice.oop;

public class Car extends Vehicle {
    String fuelType;

    public Car(String brand, double speed, String fuelType) {
        super(brand, speed);
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.printf("%s is driving on %s.\n",this.brand, this.fuelType);
//        System.out.println("Car is driving on " + fuelType);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Fuel: %s", this.fuelType);
    }

}
