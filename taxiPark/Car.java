package com.epam.task.taxiPark;

import java.util.Objects;

public abstract class Car {
    String model;
    int valueInDollars;
    int fuelConsumption;

    public Car() {
    }

    public Car(String model, int value, int fuelConsumption) {
        this.model = model;
        this.valueInDollars = value;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public int getValueInDollars() {
        return valueInDollars;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setValueInDollars(int valueInDollars) {
        this.valueInDollars = valueInDollars;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", valueInDollars=" + valueInDollars +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return valueInDollars == car.valueInDollars &&
                fuelConsumption == car.fuelConsumption &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, valueInDollars, fuelConsumption);
    }
}
