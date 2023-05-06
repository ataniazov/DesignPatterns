package com.designpatterns.showroom;

import java.util.*;

abstract class Vehicle { // Abstract class having declartion of Clone() method
    // Class Variables

    protected int seats;
    protected int tyres;
    protected String color;
    protected String fuel;

    public Vehicle() { // Default Constructor

    }

    public Vehicle(Vehicle v) { // Parameterized Constructor
        if (v != null) { // Checking passed object is null or not
            // Copying values from original object into the prototyped object
            this.seats = v.seats;
            this.tyres = v.tyres;
            this.color = v.color;
            this.fuel = v.fuel;
        }
    }

    public abstract Vehicle clone(); // Abstract Clone() method - Child classes implement this method 

    @Override
    public String toString() { // Overriding toString() method so that we can get desired print format
        return "Seats: " + this.seats + "\nTyres: " + this.tyres + "\nColor: " + this.color + "\nFuel: " + this.fuel + "\n";
    }
}

class Bike extends Vehicle { // First child class

    public Bike() { // Default Constructor

    }

    public Bike(Bike b) { // Parameterized Constructor 
        super(b); // Calling Parent class to initialize the object
    }

    @Override
    public Vehicle clone() {
        return new Bike(this); // Cloning current object with exact same functionality
    }
}

class Car extends Vehicle { // Second child class

    public Car() { // Default Constructor

    }

    public Car(Car c) { // Parameterized Constructor
        super(c); // Calling Parent class to initialize the object
    }

    @Override
    public Vehicle clone() {
        return new Car(this); // Cloning current object with exact same functionality
    }
}

public class Showroom {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>(); // List for Original objects
        List<Vehicle> vehiclesCopy = new ArrayList<>(); // List for Cloned objects

        Bike b1 = new Bike(); // Demo Bike object
        b1.seats = 1;
        b1.tyres = 2;
        b1.color = "Black";
        b1.fuel = "Petrol";
        vehicles.add(b1);

        Car c1 = new Car(); // Demo Car object
        c1.seats = 5;
        c1.tyres = 4;
        c1.color = "White";
        c1.fuel = "Electric";
        vehicles.add(c1);

        for (Vehicle vehicle : vehicles) { // cloning each object of 'vehiles' list
            vehiclesCopy.add(vehicle.clone());
        }
        System.out.print("Original Objects:-\n");
        for (Vehicle vehicle : vehicles) { // Printing Original objects
            System.out.println(vehicle.toString());
            System.out.println("---------------------------------------------------------");
        }
        System.out.print("\n\n\nPrototyped Objects:-\n");
        for (Vehicle vehicle : vehiclesCopy) { // Printing cloned objects
            System.out.println(vehicle.toString());
            System.out.println("---------------------------------------------------------");
        }
    }
}
