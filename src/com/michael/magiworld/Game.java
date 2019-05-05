package com.michael.magiworld;

public class Game {
    private Player player1;
    private Player player2;

    public void createPlayers() {
        PlayerCreator playerCreator = new PlayerCreator();

        System.out.println("Création du personnage du joueur 1");
        player1 = playerCreator.createPlayer();
        System.out.println("Création du personnage du joueur 2");
        player2 = playerCreator.createPlayer();
    }
}
