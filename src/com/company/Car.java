package com.company;

public class Car {

    private String make;
    private String model;
    private int year;
    private String plant_number;

    public Car() {
    }

    public Car(String make, String model, int year, String plant_number) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plant_number = plant_number;
    }

    @Override
    public String toString() {
        return year + " " +  make + " " + model + " (" + plant_number + ")" ;
    }
}
//-------------------------------------------------------------------