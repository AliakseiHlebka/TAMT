package com.epam.task.TAMT.taxiPark;

import java.util.Objects;

public class PassengerCar extends Car {

    int passengersNumber;

    public PassengerCar() {
    }

    public PassengerCar(String model, int valueInDollars, int fuelConsumption, int passengersNumber) {
        super(model, valueInDollars, fuelConsumption);
        this.passengersNumber = passengersNumber;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return passengersNumber == that.passengersNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersNumber);
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "model='" + model + '\'' +
                ", valueInDollars=" + valueInDollars +
                ", fuelConsumption=" + fuelConsumption +
                ", passengersNumber=" + passengersNumber +
                '}';
    }
}
