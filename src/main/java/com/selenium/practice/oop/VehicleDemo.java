package com.selenium.practice.oop;

public class VehicleDemo {
    public static void main(String[] args) {
        //Polymorphism
        Vehicle myVehicle = new Car("Toyota",100,"Gasoline");
        myVehicle.drive();

        Vehicle myVehicle2 = new Vehicle("Honda",100);
        myVehicle2.drive();

        Vehicle[] garage = new Vehicle[2];
        garage[0] = myVehicle;
        garage[1] = myVehicle2;

        System.out.println("Printing all vehicles in garage:");
        for(Vehicle v : garage){
            v.drive();
        }
    }
}
