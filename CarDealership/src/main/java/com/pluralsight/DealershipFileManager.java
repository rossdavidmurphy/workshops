package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
//                String[]  = line.split("\\|");
//                System.out.println();
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