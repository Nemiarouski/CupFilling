package com.intexsoft.testproject.utils;

import java.util.Scanner;

public class ConsoleUtils {
    private final static Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();
    }

    public static int inputFlagValidate(int flag) {
        int inputNumber;
        do {
            System.out.println("[INFO]: Input number 1-" + flag + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("[INFO]: Input number 1-" + flag + ":");
                scanner.next();
            }
            inputNumber = scanner.nextInt();
        } while (inputNumber <= 0 | inputNumber > flag);
        return inputNumber;
    }

    public static int inputValidate() {
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
}