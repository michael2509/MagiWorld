package com.michael.magiworld;

import java.util.Scanner;

public class PlayerSetter {
    private Scanner scanner = new Scanner(System.in);
    private int remainingPoints = 100;

    /**
     * Set all player's attributes
     * @param player the player that we add attributes to
     */
    public Player setAttributes(Player player) {
        setAttribute("Level And LifePoints", player);
        remainingPoints = player.getLevel();

        setAttribute("Strength", player);
        remainingPoints -= player.getStrength();

        setAttribute("Agility", player);
        remainingPoints -= player.getAgility();

        setAttribute("Intelligence", player);

        return player;
    }

    private void setAttribute(String attributeName, Player player) {
        displayAttributeQuestion(attributeName);
        int attributeValue = chooseAttributeValue(attributeName);
        assignAttributeValue(player, attributeName, attributeValue);
    }

    private void displayAttributeQuestion(String attributeName) {
        String attributeQuestion = "";

        switch (attributeName) {
            case "Level And LifePoints" :
                attributeQuestion = "Niveau du personnage ?";
                break;
            case "Strength" :
                attributeQuestion = "Force du personnage ? (Il vous reste " + remainingPoints + " points à attribuer)";
                break;
            case "Agility" :
                attributeQuestion = "Agilité du personnage ? (Il vous reste " + remainingPoints + " points à attribuer)";
                break;
            case "Intelligence" :
                attributeQuestion = "Intelligence du personnage ? (Il vous reste " + remainingPoints + " points à attribuer)";
                break;
        }

        System.out.println(attributeQuestion);
    }

    private String getCorrectErrorMsg(String attributeName) {
        String errorMessage = "";

        if (remainingPoints == 0)
            errorMessage = "Erreur de saisie ! Vous n'avez plus de point à attribuer. Tapez 0";
        else {
            switch (attributeName) {
                case "Level And LifePoints" :
                    errorMessage = "Erreur de saisie ! Veuillez saisir un nombre entre 1 et 100";
                    break;
                case "Strength" :
                case "Agility" :
                    errorMessage = "Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints;
                    break;
                case "Intelligence" :
                    errorMessage = "Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence";
                    break;
            }
        }

        return errorMessage;
    }

    private int chooseAttributeValue(String attributeName) {
        InputParser inputParser = new InputParser();
        String errorMessage = getCorrectErrorMsg(attributeName);
        int attributeValue = 0;

        switch (attributeName) {
            case "Level And LifePoints" :
                attributeValue = inputParser.parseInput(scanner, 1, 100, errorMessage);
                break;
            case "Strength" :
            case "Agility" :
                attributeValue = inputParser.parseInput(scanner, 0, remainingPoints, errorMessage);
                break;
            case "Intelligence" :
                attributeValue = inputParser.parseInputForIntelligence(scanner, remainingPoints, errorMessage);
                break;
        }

        return attributeValue;
    }

    private void assignAttributeValue(Player player, String attributeName, int attributeValue) {
        switch (attributeName) {
            case "Level And LifePoints" :
                player.setLevelAndLifePoints(attributeValue);
                break;
            case "Strength" :
                player.setStrength(attributeValue);
            case "Agility" :
                player.setAgility(attributeValue);
                break;
            case "Intelligence" :
                player.setIntelligence(attributeValue);
                break;
        }
    }
}
