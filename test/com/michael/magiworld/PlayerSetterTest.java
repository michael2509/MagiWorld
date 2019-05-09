package com.michael.magiworld;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerSetterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private void setInValues(String values) {
        System.setIn(new ByteArrayInputStream(values.getBytes()));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_GoodAnswer_When_AskingToSetAttributes_Then_PlayerHasGoodAttributes() {
        setInValues("15\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        assertEquals(player.getLevel(), 15);
        assertEquals(player.getLifePoints(), 75);
        assertEquals(player.getStrength(), 5);
        assertEquals(player.getAgility(), 5);
        assertEquals(player.getIntelligence(), 5);
    }

    @Test
    public void Given_AnswerString_When_AskingToSetLevel_Then_AskAgainQuestion() {
        setInValues("dix\n15\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre entre 1 et 100", output[1]);
    }

    @Test
    public void Given_AnswerTooHighValue_When_AskingToSetLevel_Then_AskAgainQuestion() {
        setInValues("120\n15\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre entre 1 et 100", output[1]);
    }

    @Test
    public void Given_AnswerZero_When_AskingToSetLevel_Then_AskAgainQuestion() {
        setInValues("0\n15\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre entre 1 et 100", output[1]);
    }

    @Test
    public void Given_AnswerNegativeValue_When_AskingToSetLevel_Then_AskAgainQuestion() {
        setInValues("-50\n15\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre entre 1 et 100", output[1]);
    }

    @Test
    public void Given_AnswerString_When_AskingToSetStrength_Then_AskAgainQuestion() {
        setInValues("15\ncinq\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints, output[2]);
    }

    @Test
    public void Given_AnswerTooHighValue_When_AskingToSetStrength_Then_AskAgainQuestion() {
        setInValues("15\n60\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints, output[2]);
    }

    @Test
    public void Given_AnswerNegativeValue_When_AskingToSetStrength_Then_AskAgainQuestion() {
        setInValues("15\n-10\n5\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints, output[2]);
    }

    @Test
    public void Given_AnswerString_When_AskingToSetAgility_Then_AskAgainQuestion() {
        setInValues("15\n5\ncinq\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints, output[3]);
    }

    @Test
    public void Given_AnswerTooHighValue_When_AskingToSetAgility_Then_AskAgainQuestion() {
        setInValues("15\n5\n60\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints, output[3]);
    }

    @Test
    public void Given_AnswerNegativeValue_When_AskingToSetAgility_Then_AskAgainQuestion() {
        setInValues("15\n5\n-10\n5\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un nombre de 0 à " + remainingPoints, output[3]);
    }

    @Test
    public void Given_NoRemainingPoints_When_TryingToSetAgility_Then_DisplayCorrectErrorMsg() {
        setInValues("15\n15\n100\n0\n0");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Vous n'avez plus de point à attribuer. Tapez 0", output[3]);
    }

    @Test
    public void Given_AnswerString_When_AskingToSetIntelligence_Then_AskAgainQuestion() {
        setInValues("15\n5\n5\nzero\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength() - player.getAgility();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence", output[4]);
    }

    @Test
    public void Given_AnswerTooHighValue_When_AskingToSetIntelligence_Then_AskAgainQuestion() {
        setInValues("15\n5\n5\n60\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength() - player.getAgility();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence", output[4]);
    }

    @Test
    public void Given_AnswerTooLowValue_When_AskingToSetIntelligence_Then_AskAgainQuestion() {
        setInValues("15\n5\n5\n2\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength() - player.getAgility();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence", output[4]);
    }

    @Test
    public void Given_AnswerNegativeValue_When_AskingToSetIntelligence_Then_AskAgainQuestion() {
        setInValues("15\n5\n5\n-10\n5");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength() - player.getAgility();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Vous devez attribuer les " + remainingPoints + " restants en intelligence", output[4]);
    }

    @Test
    public void Given_NoRemainingPoints_When_TryingToSetIntelligence_Then_DisplayCorrectErrorMsg() {
        setInValues("15\n5\n10\n100\n0");

        Player player = new Player();

        PlayerSetter playerSetter = new PlayerSetter();
        playerSetter.setAttributes(player);

        int remainingPoints = player.getLevel() - player.getStrength() - player.getAgility();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Vous n'avez plus de point à attribuer. Tapez 0", output[4]);
    }
}