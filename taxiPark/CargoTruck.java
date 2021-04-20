package com.epam.task.taxiPark;

import java.util.Objects;

public class CargoTruck extends Car {

    int cargoCapacityInKg;

    public CargoTruck() {
    }

    public CargoTruck(String model, int value, int fuelConsumption, int cargoCapacityInKg) {
        super(model, value, fuelConsumption);
        this.cargoCapacityInKg = cargoCapacityInKg;
    }

    public int getCargoCapacityInKg() {
        return cargoCapacityInKg;
    }

    public void setCargoCapacityInKg(int cargoCapacityInKg) {
        this.cargoCapacityInKg = cargoCapacityInKg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoTruck that = (CargoTruck) o;
        return cargoCapacityInKg == that.cargoCapacityInKg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacityInKg);
    }

    @Override
    public String toString() {
        return "CargoTruck{" +
                "model='" + model + '\'' +
                ", valueInDollars=" + valueInDollars +
                ", fuelConsumption=" + fuelConsumption +
                ", cargoCapacityInKg=" + cargoCapacityInKg +
                '}';
    }
}


