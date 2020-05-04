package com.codecool.ants;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Colony colony = new Colony(20);

        System.out.println("Press Space for next move or any other key to quit: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        while (inputString.equals(" ")) {
            System.out.println("Currently there are " + (colony.getAnts().size() + 1) + " ant in the colony.");
            colony.nextStep();
            System.out.println(colony.toString());
            scanner = new Scanner(System.in);
            inputString = scanner.nextLine();
            System.out.print("Input: ");
        }

    }
}