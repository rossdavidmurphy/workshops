package FinancialCalculators;

import java.util.Scanner;

public class FutureCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Current Price: ");
        double currentPrice = input.nextDouble();
        System.out.println("Enter Interest Rate: ");
        double interestRate = input.nextDouble();
        System.out.println("Enter Time Duration (In Years): ");
        int duration = input.nextInt();

        double futureValue = currentPrice * Math.pow(1 + (interestRate / 365), 365 * duration);
        double totalInterest = futureValue - currentPrice;

        System.out.printf("If you deposit $%.2f in a CD that earns %.2f%% interest and matures %d years, your CD's ending balance will be $%.2f and you would have earned $%.2f in interest.", currentPrice, interestRate, duration, futureValue, totalInterest);
    }
}
