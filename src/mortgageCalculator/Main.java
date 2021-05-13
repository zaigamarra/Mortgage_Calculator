package mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal;
        float annualInterestRate;
        float monthlyInterest;
        byte years;
        int numberOfPayments;
        double mortgage;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Ingresar un valor entre 1000 y 1000000");
        }

        while (true){
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30){
                monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Ingresar un valor entre 1 y 30");
        }

        while (true){
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >=1 && years <=30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Ingresar un valor entre 1 y 30");
        }

        mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                                    /(Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
