package model;

public class Vehicle {
    private  int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("+-----------------+-----------------------+\n");
        sb.append("| %-15s | %-21s |\n".formatted(make, model));
        sb.append("+-----------------+-----------------------+\n");

        sb.append("| %-15s | %-21s |\n".formatted("VIN", vin));
        sb.append("| %-15s | %-21d |\n".formatted("Year", year));
        sb.append("| %-15s | %-21s |\n".formatted("Vehicle Type", vehicleType));
        sb.append("| %-15s | %-21s |\n".formatted("Color", color));
        sb.append("| %-15s | %-21d |\n".formatted("Odometer", odometer));
        sb.append("| %-15s | $%,.2f |\n".formatted("Price", price));

        sb.append("+-----------------+-----------------------+\n");

        return sb.toString();
    }

}
