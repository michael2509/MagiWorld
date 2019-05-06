package com.michael.magiworld;

import java.util.Scanner;

public class PlayerSetter {
    private Scanner sc = new Scanner(System.in);
    private int remainingPoints;

    /**
     * Set all player's attributes
     * @param player the player that we add attributes to
     */
    public void setAttributes(Player player) {
        setLevelAndLifePoints(player);
        remainingPoints = player.getLevel();

        setStrength(player);
        remainingPoints -= player.getStrength();

        setAgility(player);
        remainingPoints -= player.getAgility();

        setIntelligence(player);
    }

    private void setLevelAndLifePoints(Player player) {
        System.out.println("Niveau du personnage ?");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Veuillez saisir un nombre entre 1 et 100";

        int newLevel = inputParser.parseInput(sc,1, 100, errorMessage);

        player.setLevelAndLifePoints(newLevel);
    }

    private void setStrength(Player player) {
        System.out.println("Force du personnage ? (Il vous reste " + remainingPoints + " points à attribuer)");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints;

        int newStrength = inputParser.parseInput(sc,0, remainingPoints, errorMessage);

        player.setStrength(newStrength);
    }

    private void setAgility(Player player) {
        System.out.println("Agilité du personnage ? (Il vous reste " + remainingPoints + " points à attribuer)");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints;

        int newAgility = inputParser.parseInput(sc,0, remainingPoints, errorMessage);

        player.setAgility(newAgility);
    }

    private void setIntelligence(Player player) {
        System.out.println("Intelligence du personnage ? (Vous devez attribuer les " + remainingPoints + " points restants en intelligence)");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence";

        int newIntelligence = inputParser.parseInputForIntelligence(sc, remainingPoints, errorMessage);

        player.setIntelligence(newIntelligence);
    }
}
