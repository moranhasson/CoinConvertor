package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinTest {
    static ArrayList<Double> convertedCoinList;

    public static void main(String[] args) {
        convertedCoinList = new ArrayList<>();
        cointProgram(convertedCoinList);
    }

    private static void cointProgram(ArrayList<Double> convertedCoinList) {
        Scanner scanner = new Scanner(System.in);
        Coin coin = null;
        System.out.println("Welcome to currency converter");
        System.out.println("Please choose an option (1/2)");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
        boolean inputOk = false;
        while (!inputOk) {
            try {
                int answer = scanner.nextInt();
                if (!Arrays.asList(1, 2).contains(answer)) {
                    throw new InputMismatchException();
                }
                inputOk = true;
                if (answer == 1) {
                    coin = CoinFactory.getCoinInstance(Coins.USD);
                } else if (answer == 2) {
                    coin = CoinFactory.getCoinInstance(Coins.ILS);
                }
            } catch (InputMismatchException e) {
                System.err.println("please try again - only allowed to select 1 or 2");
                scanner.nextLine();
            }
        }
        System.out.println("Please enter an amount to convert");
        double convert = coin.calculate(scanner.nextDouble());
        System.out.println("the results is " + convert);
        convertedCoinList.add(convert);
        System.out.println("do you want to continue?");
        String shouldContinue = scanner.next();
        if (shouldContinue.equalsIgnoreCase("Y")) {
            CoinTest.cointProgram(convertedCoinList);
        } else if (shouldContinue.equalsIgnoreCase("N")) {
            System.out.println("Thanks for using our currency converter");
            System.out.println("your previous results are: " + convertedCoinList);
            try {
                FileWriter writer = new FileWriter("results.txt");
                for (Double aDouble : convertedCoinList) {
                    writer.write(aDouble + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
