package com.epam.task.taxiPark;

import java.util.Comparator;

public class CarFuelConsumptionComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
//        return o1.getFuelConsumption().compareTo(o2.getFuelConsumption());
        return Integer.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }
}
