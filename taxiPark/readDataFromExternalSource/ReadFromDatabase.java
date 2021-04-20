package com.epam.task.taxiPark.readDataFromExternalSource;

import com.epam.task.taxiPark.Car;
import com.epam.task.taxiPark.CargoTruck;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromDatabase implements ReadDataFromExternalSource {

    @Override
    public List<Car> read() {
        List<Car> cars = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "pass");
            Statement statement = connection.createStatement();
            String query = "SELECT car_id, model, value_in_usd, fuel_consumption, cargo_capacity_in_kg FROM cargo_trucks";
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String model = results.getString(2);
                int valueInDollars = results.getInt(3);
                int fuelConsumption = results.getInt(4);
                int cargoCapacityInKg = results.getInt(5);
                cars.add(new CargoTruck(model, valueInDollars, fuelConsumption, cargoCapacityInKg));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
