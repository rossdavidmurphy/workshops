package data;

import model.Dealership;
import model.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {


    public Dealership getDealership() {

        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("data/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String[] dealershipFields = line.split("\\|");
            dealership = new Dealership(dealershipFields[0], dealershipFields[1], dealershipFields[2]);

            while ((line = bufferedReader.readLine()) != null) {
                String[] vehicleFields = line.split("\\|");
                if (vehicleFields.length == 8) {
                    int vin = Integer.parseInt(vehicleFields[0]);
                    int year = Integer.parseInt(vehicleFields[1]);
                    String make = vehicleFields[2];
                    String model = vehicleFields[3];
                    String vehicleType = vehicleFields[4];
                    String color = vehicleFields[5];
                    int odometer = Integer.parseInt(vehicleFields[6]);
                    double price = Double.parseDouble(vehicleFields[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {

    }
}