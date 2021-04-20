package com.epam.task.taxiPark;

import com.epam.task.taxiPark.exception.CarNotFoundException;
import com.epam.task.taxiPark.exception.DeleteAllParkException;
import com.epam.task.taxiPark.exception.TooBigConsumptionException;
import com.epam.task.taxiPark.readDataFromExternalSource.ReadFromDatabase;
import com.epam.task.taxiPark.readDataFromExternalSource.ReadFromXmlFile;

import java.util.ArrayList;
import java.util.List;

import static com.epam.task.taxiPark.CarFilter.ComparingOperators.LESS;
import static com.epam.task.taxiPark.CarFilter.ComparingOperators.MORE;

public class TaxiFleet {
    private ArrayList<Car> listOfCars;

    public TaxiFleet(ArrayList<Car> listOfCars) {
        this.listOfCars = listOfCars;
    }

    public static void main(String[] args) {
        PassengerCar polo = new PassengerCar("Volkswagen Polo", 10000, 6, 4);
        PassengerCar rio = new PassengerCar("KIA Rio", 11000, 7, 4);
        PassengerCar zafira = new PassengerCar("Opel Zafira", 20000, 7, 6);
        CargoTruck transit = new CargoTruck("Ford Transit", 30000, 9, 2000);

        ArrayList<Car> listOfCars = new ArrayList<>();          // Task 2.1.6. Create taxi fleet
        listOfCars.add(polo);
        listOfCars.add(rio);
        listOfCars.add(zafira);
        listOfCars.add(transit);

        TaxiFleet fleet = new TaxiFleet(listOfCars);

        System.out.println("Total value of the taxi fleet is " + fleet.calculateCarsValue() + " USD" + "\n");     //Task 2.1.6. Calculate total cost of taxi fleet
        System.out.println("Sorted list of cars by fuel consumption:");
        fleet.sortCarsByFuelConsumption();          // Task 2.1.6. Sort cars by fuel consumption
        System.out.println("\n" + "Filter cars by parameters:");
        fleet.filterCarsByParams(new CarFilter(20000, 8, MORE, LESS));      //Task 2.1.6. Filter cars by predifined parameters
        System.out.println("\n" + "Throw custom exceptions:");
        try {
            fleet.removeCar(new CarFilter(50000, 0, MORE, null));       // Task 3.1. Throw custom exception No.1
        } catch (CarNotFoundException e) {
            System.out.println("Car was not found!");
        }
        try {
            fleet.removeCar(new CarFilter(0, 10, null, LESS));      // Task 3.1. Throw custom exception No.2
        } catch (DeleteAllParkException e) {
            System.out.println("You are going to remove all cars!");
        }
        try {
            fleet.addCar(new PassengerCar("Toyota Land Cruiser", 80000, 20, 4));        // Task 3.1. Throw custom exception No.3
        } catch (TooBigConsumptionException e) {
            System.out.println("This car consumes too much fuel! It is not suitable for taxi!");
        }
        System.out.println("\n" + "Read data from a file:");
        new FileInputAndOutput().writeDataToFile(listOfCars);       // Task 3.2. Write data to a file.
        System.out.println(new FileInputAndOutput().readDataFromFile("d:/data.txt"));       // Task 3.2. Read data from a file

        System.out.println("\n" + "Read data from database:" + "\n" + new ReadFromDatabase().read());      // Task 4.1. Read data from Database
        System.out.println("\n" + "Read data from xml file:" + "\n" + new ReadFromXmlFile("D://new.xml").read());      // Task 4.1. Read data from xml file
    }

    public int calculateCarsValue() {
        int carsValue = 0;
        for (Car listOfCar : listOfCars) {
            carsValue += listOfCar.valueInDollars;
        }
        return carsValue;
    }

    public void sortCarsByFuelConsumption() {
        listOfCars.sort(new CarFuelConsumptionComparator());
        System.out.println(listOfCars);
    }

    public void filterCarsByParams(CarFilter filter) {
        for (Car car : listOfCars) {
            if (filter.isOk(car)) {
                System.out.println(car);
            }
        }
    }

    // method for throwing custom exceptions
    public void removeCar(CarFilter filter) {
        List<Car> carsForRemoval = new ArrayList<>();
        for (Car car : listOfCars) {
            if (filter.isOk(car)) {
                carsForRemoval.add(car);
            }
        }
        if (carsForRemoval.isEmpty()) {
            throw new CarNotFoundException();
        } else {
            if (carsForRemoval.size() == listOfCars.size()) {
                throw new DeleteAllParkException();
            }
            listOfCars.removeAll(carsForRemoval);
        }
    }

    //method for throwing custom exception
    public void addCar(Car car) {
        if (car.getFuelConsumption() > 10) {
            throw new TooBigConsumptionException();
        }
        listOfCars.add(car);
    }
}
