package com.pluralsight;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);

    Dealership dealership;
    private void initialize() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public void display() {
        initialize();
        System.out.println("\n Main Menu");
        System.out.println("Press 1 to request Price Range");
        System.out.println("Press 2 to request Make & Model");
        System.out.println("Press 3 to request Year");
        System.out.println("Press 4 to request Color");
        System.out.println("Press 5 to request Mileage");
        System.out.println("Press 6 to request Vehicle Type");
        System.out.println("Press 7 to request All Vehicles");
        System.out.println("Press 8 to remove Vehicle");

        String selectMenuOption = input.nextLine();

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        switch (selectMenuOption) {
            case "1":

               vehicles = dealership.getVehiclesByPrice(1.0, 29000.0);
                break;
            case "2":
                dealership.getVehiclesByMakeModel();
                break;
            case "3":
                dealership.getVehiclesByYear();
                break;
            case "4":
                dealership.getVehiclesByColor();
                break;
            case "5":
                dealership.getVehiclesByMileage();
                break;
            case "6":
                dealership.getVehicleByType();
                break;
            case "7":
                dealership.getAllVehicles();
                break;
            case "8":
                dealership.removeVehicle();
                break;
            default:
                System.out.println("Invalid menu option! Please try again!");
        }
        displayVehicles(vehicles);
    }
     public void displayVehicles(ArrayList<Vehicle> vehicles) {
         for (Vehicle vehicle : vehicles) {
             System.out.println(vehicle);
         }

     }
}
