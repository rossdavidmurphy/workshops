package UserInterface;

import data.DealershipFileManager;
import model.Dealership;
import model.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);

    Dealership dealership;
    private void initialize() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
//        this.dealership = new DealershipFileManager().getDealership(); // <<< condensed version
    }

    public void display() {
        initialize();
        System.out.println("\n Main Menu");
        System.out.println("Press 1 to search by Price Range");
        System.out.println("Press 2 to search by Make & Model");
        System.out.println("Press 3 to search by Year");
        System.out.println("Press 4 to search by Color");
        System.out.println("Press 5 to search by Mileage");
        System.out.println("Press 6 to search by Vehicle Type");
        System.out.println("Press 7 to show All Vehicles");
        System.out.println("Press 8 to remove a Vehicle by VIN");
        System.out.println("Press 9 to add a Vehicle");

        String selectMenuOption = input.nextLine();

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        switch (selectMenuOption) {
            case "1":
                System.out.println("Enter minimum price: ");
                double min = input.nextDouble();
                System.out.println("Enter maximum price: ");
                double max = input.nextDouble();
                vehicles = dealership.getVehiclesByPrice(min, max);
                break;

            case "2":
                System.out.println("Enter Vehicle Make: ");
                String make = input.nextLine();
                System.out.println("Enter Vehicle Model: ");
                String model = input.nextLine();
                vehicles = dealership.getVehiclesByMakeModel(make, model);
                break;

            case "3":
                System.out.println("Enter minimum year: ");
                int minYear = input.nextInt();
                System.out.println("Enter maximum year: ");
                int maxYear = input.nextInt();
                vehicles = dealership.getVehiclesByYear(minYear, maxYear);
                break;

            case "4":
                System.out.println("Enter vehicle color: ");
                String vehicleColor = input.nextLine();
                vehicles = dealership.getVehiclesByColor(vehicleColor);
                break;

            case "5":
                System.out.println("Enter minimum mileage: ");
                int minMileage = input.nextInt();
                System.out.println("Enter maximum mileage: ");
                int maxMileage = input.nextInt();
                vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
                break;

            case "6":
                System.out.println("Enter vehicle type: ");
                String vehicleType = input.nextLine();
                vehicles = dealership.getVehicleByType(vehicleType);
                break;

            case "7":
                vehicles = dealership.getAllVehicles();
                break;

            case "8":
                System.out.println("Enter vehicle identification number (VIN) to remove: ");
                int removeVehicleByVinNumber = input.nextInt();

                Vehicle vinToRemove = null;
                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    if (vehicle.getVin() == removeVehicleByVinNumber) {
                        vinToRemove = vehicle;
                        break;
                    }
                }
                if (vinToRemove != null) {
                    dealership.removeVehicle(vinToRemove);
                    DealershipFileManager dealershipFileManager = new DealershipFileManager();
                    dealershipFileManager.saveDealership(dealership);

                    System.out.println("Vehicle removed." + "\nVehicle Information: \n" + vinToRemove);
                }
                else {
                    System.out.println("Vehicle not found.");
                }
                break;
            case "9":

                System.out.println("Enter vehicle identification number (VIN): ");
                int
                break;

            default:
                System.out.println("Invalid menu option! Please try again!");
        }
        displayVehicles(vehicles);
    }
     public void displayVehicles(ArrayList<Vehicle> vehicles) {
         if (vehicles.isEmpty()) {
             System.out.println("No vehicles found.");
         } else {
             for (Vehicle vehicle : vehicles) {
                 System.out.println(vehicle);
             }
         }
     }

//    public void processAllVehiclesRequest() {
//        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
//        displayVehicles(vehicles);
//    }
}
