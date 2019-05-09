package com.michael.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputParser {

    /**
     * Check the input value,
     * If the input value is invalid, show error message until inputValue is valid,
     * Then if the input value is correct, returns it.
     * @param sc the input scanner
     * @param lowerLimit lower limit value for the input value
     * @param higherLimit higher limit value for the input value
     * @param errorMessage message to show if the input value is invalid
     * @return the correct input value
     */
    public int parseInput(Scanner sc, int lowerLimit, int higherLimit, String errorMessage) {
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

    /**
     * Check the input Value,
     * If the input value is not equal to the condition, show error message until inputValue is valid,
     * Then if the input value is equal to the condition, returns it.
     * @param sc the input scanner
     * @param condition the condition input value has to be equal
     * @param errorMessage  message to show if the input value is not equal to the condition
     * @return the correct input value
     */
    public int parseInputForIntelligence(Scanner sc, int condition, String errorMessage) {
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
