package FinancialCalculators;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Loan Amount: ");
        double loanAmount = input.nextDouble();
        System.out.println("Enter Annual Interest Rate: ");
        double annualInterestRate = input.nextDouble();
        System.out.println("Enter Loan Duration (In Years): ");
        int loanDuration = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 100 / 12;
        double totalPayment = loanDuration * 12;

        double monthlyPayment = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalPayment) / (Math.pow(1 + monthlyInterestRate, totalPayment) - 1));


        System.out.printf("With a $%.2f loan at %.3f%% interest for %d years, you would pay $%.2f a month.", loanAmount, annualInterestRate, loanDuration, monthlyPayment);

    }
}
