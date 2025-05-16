package model;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle :inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dealership{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", inventory=").append(inventory);
        sb.append('}');
        return sb.toString();
    }
}
