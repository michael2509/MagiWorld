package com.michael.magiworld;

public class Game {
    private Player player1;
    private Player player2;

    /**
     * Create players,
     * Set players attributes
     * Then fight
     */
    public void playGame() {
        createPlayer(1);
        setPlayer(1);

        createPlayer(2);
        setPlayer(2);
    }

    private void createPlayer(int playerPosition) {
        PlayerCreator playerCreator = new PlayerCreator();

        System.out.println("Création du personnage du joueur " + playerPosition);

        switch (playerPosition) {
            case 1 :
                player1 = playerCreator.createPlayer();
                break;
            case 2 :
                player2 = playerCreator.createPlayer();
                break;
        }
    }

    private void setPlayer(int playerPosition) {
        PlayerSetter playerSetter = new PlayerSetter();

        switch (playerPosition) {
            case 1 :
                playerSetter.setAttributes(player1);
                break;
            case 2 :
                playerSetter.setAttributes(player2);
                break;
        }
    }
}
