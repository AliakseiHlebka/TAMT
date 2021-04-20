package com.epam.task.taxiPark;

public class CarFilter {
    int valueInDollars;
    int fuelConsumption;
    ComparingOperators comparedValueInDollars;

    ComparingOperators comparedFuelConsumption;

    public CarFilter(int valueInDollars, int fuelConsumption, ComparingOperators comparedValueInDollars, ComparingOperators comparedFuelConsumption) {
        this.valueInDollars = valueInDollars;
        this.fuelConsumption = fuelConsumption;
        this.comparedValueInDollars = comparedValueInDollars;
        this.comparedFuelConsumption = comparedFuelConsumption;
    }
    
    public boolean isOk(Car car) {
        boolean ok = true;
        if (comparedValueInDollars != null) {
            if (comparedValueInDollars.equals(ComparingOperators.EQUAL)) {
                if (car.getValueInDollars() != valueInDollars) {
                    ok = false;
                }
            }
            if (comparedValueInDollars.equals(ComparingOperators.LESS)) {
                if (car.getValueInDollars() > valueInDollars) {
                    ok = false;
                }
            }
            if (comparedValueInDollars.equals(ComparingOperators.MORE)) {
                if (car.getValueInDollars() < valueInDollars) {
                    ok = false;
                }
            }
        }
        if (comparedFuelConsumption != null) {
            if (comparedFuelConsumption.equals(ComparingOperators.EQUAL)) {
                if (car.getFuelConsumption() != fuelConsumption) {
                    ok = false;
                }
            }
            if (comparedFuelConsumption.equals(ComparingOperators.LESS)) {
                if (car.getFuelConsumption() > fuelConsumption) {
                    ok = false;
                }
            }
            if (comparedFuelConsumption.equals(ComparingOperators.MORE)) {
                if (car.getFuelConsumption() < fuelConsumption) {
                    ok = false;
                }
            }
        }
        return ok;
    }
    
    
    
    
    public enum ComparingOperators {
        MORE, LESS, EQUAL;
    }
    
    
}
