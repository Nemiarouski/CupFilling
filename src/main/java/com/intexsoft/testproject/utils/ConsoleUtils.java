package com.intexsoft.testproject.utils;

import java.util.Scanner;

public class ConsoleUtils {
    private final static Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();
    }

    public static int validateIntToValue(int value) {
        int inputNumber;
        do {
            System.out.println("[INFO]: Input number 1-" + value + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("[INFO]: Input number 1-" + value + ":");
                scanner.next();
            }
            inputNumber = scanner.nextInt();
        } while (inputNumber <= 0 | inputNumber > value);
        return inputNumber;
    }

    public static int validateInt() {
        int inputNumber;
        do {
            System.out.println("[INFO]: Input positive number:");
            while (!scanner.hasNextInt()) {
                System.out.println("[INFO]: Input positive number:");
                scanner.next();
            }
            inputNumber = scanner.nextInt();
        } while (inputNumber <= 0);
        return inputNumber;
    }

    public static double validateDouble() {
        double inputNumber;
        do {
            System.out.println("[INFO]: Input positive number:");
            while (!scanner.hasNextDouble()) {
                System.out.println("[INFO]: Input positive number:");
                scanner.next();
            }
            inputNumber = scanner.nextDouble();
        } while (inputNumber <= 0);
        return inputNumber;
    }
}