package com.michael.magiworld;

public class PlayerSetter {
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

        int level = inputParser.parseInput(1, 100, errorMessage);

        player.setLevelAndLifePoints(level);
    }

    private void setStrength(Player player) {
        System.out.println("Force du personnage ? (Il vous reste " + remainingPoints + " à attribuer)");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints;

        int strength = inputParser.parseInput(0, remainingPoints, errorMessage);

        player.setStrength(strength);
    }

    private void setAgility(Player player) {
        System.out.println("Agilité du personnage ? (Il vous reste " + remainingPoints + " à attribuer)");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints;

        int agility = inputParser.parseInput(0, remainingPoints, errorMessage);

        player.setAgility(agility);
    }

    private void setIntelligence(Player player) {
        System.out.println("Intelligence du personnage ? (Vous devez attribuer les " + remainingPoints + " points restants en intelligence)");
        InputParser inputParser = new InputParser();

        String errorMessage = "Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence";

        int intelligence = inputParser.parseInputForIntelligence(remainingPoints, errorMessage);

        player.setIntelligence(intelligence);
    }

    public int getRemainingPoints() {
        return remainingPoints;
    }
}
