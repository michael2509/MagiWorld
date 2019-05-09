package com.michael.magiworld;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private int numberOfPlayers;
    private List<Player> players = new ArrayList<Player>();

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void initPlayers() {
        for (int i = 0; i < numberOfPlayers; i++) {
            Player newPlayer = createPlayer(i);
            Player newPlayerWithAttributes = setPlayerAttributes(newPlayer);

            players.add(newPlayerWithAttributes);
        }
    }

    private Player createPlayer(int playerIndex) {
        int playerPosition = playerIndex + 1;
        System.out.println("Création du personnage du joueur " + playerPosition);

        PlayerCreator playerCreator = new PlayerCreator();
        Player newPlayer = playerCreator.createPlayer();
        return newPlayer;
    }

    private Player setPlayerAttributes(Player player) {
        PlayerSetter playerSetter = new PlayerSetter();

        Player playerWithAttributes = playerSetter.setAttributes(player);
        return  playerWithAttributes;
    }
}
