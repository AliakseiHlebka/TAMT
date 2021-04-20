package com.epam.task.TAMT.taxiPark;

import java.util.Comparator;

public class CarFuelConsumptionComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }
}
