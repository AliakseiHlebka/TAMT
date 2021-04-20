package com.epam.task.TAMT.taxiPark;

import java.io.*;
import java.util.ArrayList;

public class FileInputAndOutput {
    final static String SEPARATOR = "|";

    private String carsToText(Car car) {
        if (car instanceof PassengerCar) {
            PassengerCar passengerCar = (PassengerCar) car;
            StringBuilder builder = new StringBuilder();
            builder.append("Passenger Car")
                    .append(SEPARATOR)
                    .append(passengerCar.getModel())
                    .append(SEPARATOR)
                    .append(passengerCar.getValueInDollars())
                    .append(SEPARATOR)
                    .append(passengerCar.getFuelConsumption())
                    .append(SEPARATOR)
                    .append(passengerCar.getPassengersNumber());
            return builder.toString();
        } if (car instanceof CargoTruck) {
            CargoTruck cargoTruck = (CargoTruck) car;
            StringBuilder builder = new StringBuilder();
            builder.append("Cargo Truck")
                    .append(SEPARATOR)
                    .append(cargoTruck.getModel())
                    .append(SEPARATOR)
                    .append(cargoTruck.getValueInDollars())
                    .append(SEPARATOR)
                    .append(cargoTruck.getFuelConsumption())
                    .append(SEPARATOR)
                    .append(cargoTruck.getCargoCapacityInKg());
            return builder.toString();
        }
        return "";
    }

    private Car textToCars(String line) {
        String[] split = line.split("\\|");
        if (split[0].equals("Passenger Car")) {
            PassengerCar passengerCar = new PassengerCar();
            passengerCar.setModel(split[1]);
            passengerCar.setValueInDollars(Integer.parseInt(split[2]));
            passengerCar.setFuelConsumption(Integer.parseInt(split[3]));
            passengerCar.setPassengersNumber(Integer.parseInt(split[4]));
            return passengerCar;
        } if (split[0].equals("Cargo Truck")) {
            CargoTruck cargoTruck = new CargoTruck();
            cargoTruck.setModel(split[1]);
            cargoTruck.setValueInDollars(Integer.parseInt(split[2]));
            cargoTruck.setFuelConsumption(Integer.parseInt(split[3]));
            cargoTruck.setCargoCapacityInKg(Integer.parseInt(split[4]));
            return cargoTruck;
        }
        return null;
    }

    public void writeDataToFile(ArrayList<Car> list) {
        try(FileOutputStream outputStream = new FileOutputStream("d:/data.txt")) {
            for (Car car : list) {
                outputStream.write(carsToText(car).getBytes("UTF-8"));
                outputStream.write("\n".getBytes("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> readDataFromFile(String fileName) {
        ArrayList<Car> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(textToCars(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
