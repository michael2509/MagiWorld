package com.michael.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputParser {
    private Scanner sc = new Scanner(System.in);

    /**
     * Check inputValue,
     * If inputValue is invalid, show error message until inputValue is valid,
     * Then return inputValue.
     * @param lowerLimit
     * @param higherLimit
     * @param errorMessage
     * @return the correct inputValue
     */
    public int parseInput(int lowerLimit, int higherLimit, String errorMessage) {
        int inputValue = 0;
        boolean goodResponse;

        do {
            try {
                inputValue = sc.nextInt();
                if (inputValue < lowerLimit || inputValue > higherLimit) {
                    System.out.println(errorMessage);
                    goodResponse = false;
                }
                else
                    goodResponse = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println(errorMessage);
                goodResponse = false;
            }
        } while (!goodResponse);

        return inputValue;
    }

    public int parseInputForIntelligence(int condition, String errorMessage) {
        int inputValue = 0;
        boolean goodResponse;

        do {
            try {
                inputValue = sc.nextInt();
                if (inputValue != condition) {
                    System.out.println(errorMessage);
                    goodResponse = false;
                }
                else
                    goodResponse = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println(errorMessage);
                goodResponse = false;
            }
        } while (!goodResponse);

        return inputValue;
    }
}
