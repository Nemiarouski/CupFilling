package project.utils;

import java.util.Scanner;

public class Console {
    public static Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();
    }

    public static Integer inputMenuValidation(int flag) {
        int temp;
        do {
            System.out.println("Input positive number between 1 and " + flag + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Input positive number between 1 and " + flag + ":");
                scanner.next();
            }
            temp = scanner.nextInt();
        } while (temp <= 0 | temp > flag);
        return temp;
    }

    public static Integer inputPositiveNumberValidation() {
        int temp;
        do {
            System.out.println("Input positive number:");
            while (!scanner.hasNextInt()) {
                System.out.println("Input positive number:");
                scanner.next();
            }
            temp = scanner.nextInt();
        } while (temp <= 0);
        return temp;
    }
}