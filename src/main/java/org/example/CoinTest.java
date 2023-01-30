package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        int answer = scanner.nextInt();
        if (answer == 1) {
            coin = CoinFactory.getCoinInstance(Coins.USD);
        } else if (answer == 2) {
            coin = CoinFactory.getCoinInstance(Coins.ILS);
        }
        System.out.println("Please enter an amount to convert");
        double convert = coin.calculate(scanner.nextDouble());
        convertedCoinList.add(convert);
        System.out.println("do you want to continue?");
        String shouldContinue = scanner.next();
        if (shouldContinue.equals("Y")) {
            CoinTest.cointProgram(convertedCoinList);
        } else if (shouldContinue.equals("N")) {
            System.out.println("Thanks for using our currency converte");
            System.out.println("your previus reaults" + convertedCoinList);
            try {
                FileWriter writer = new FileWriter("results.txt");
                for (int i = 0; i < convertedCoinList.size(); i++) {
                    writer.write(convertedCoinList.get(i) + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
