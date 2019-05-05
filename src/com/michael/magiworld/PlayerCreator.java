package com.michael.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerCreator {
    private Player player;


    public Player createPlayer() {
        int classChoice = chooseClass();

        switch (classChoice) {
            case 1 :
                player = new Warrior();
                break;
            case 2 :
                player = new Archer();
                break;
            case 3 :
                player = new Mage();
                break;
        }

        return player;
    }

    private int chooseClass() {
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");

        InputParser inputParser = new InputParser();
        String errorMessage = "Erreur de saisie ! Veuillez saisir un chiffre de 1 à 3 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)";
        int classChoice = inputParser.parseInput(1, 3, errorMessage);
        return classChoice;
    }

    public Player getPlayer() {
        return player;
    }
}
