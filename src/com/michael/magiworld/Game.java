package com.michael.magiworld;

public class Game {
    private Player player1;
    private Player player2;

    public void createPlayers() {
        PlayerManager playerManager = new PlayerManager();

        player1 = playerManager.createPlayer();
        player2 = playerManager.createPlayer();
    }
}
