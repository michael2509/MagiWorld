package com.michael.magiworld;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCreatorTest {

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
    public void Given_AnswerOne_When_AskingToChooseClass_Then_CreatePlayerWithWarriorClass() {
        setInValues("1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        Player newPlayer = playerCreator.getPlayer();

        assertTrue(newPlayer instanceof Warrior);
    }

    @Test
    public void Given_AnswerTwo_When_AskingToChooseClass_Then_CreatePlayerWithArcherClass() {
        setInValues("2");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        Player newPlayer = playerCreator.getPlayer();

        assertTrue(newPlayer instanceof Archer);
    }

    @Test
    public void Given_AnswerThree_When_AskingToChooseClass_Then_CreatePlayerWithMageClass() {
        setInValues("3");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        Player newPlayer = playerCreator.getPlayer();

        assertTrue(newPlayer instanceof Mage);
    }

    @Test
    public void Given_AnswerString_When_AskingToChooseClass_Then_AskAgainQuestion() {
        setInValues("mage\n1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un chiffre de 1 à 3 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[1]);
    }

    @Test
    public void Given_AnswerTooHighValue_When_AskingToChooseClass_Then_AskAgainQuestion() {
        setInValues("15\n1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un chiffre de 1 à 3 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[1]);
    }

    @Test
    public void Given_AnswerTooLowValue_When_AskingToChooseClass_Then_AskAgainQuestion() {
        setInValues("0\n1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un chiffre de 1 à 3 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[1]);
    }

    @Test
    public void Given_AnswerNegativeValue_When_AskingToChooseClass_Then_AskAgainQuestion() {
        setInValues("-5\n1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Erreur de saisie ! Veuillez saisir un chiffre de 1 à 3 (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[1]);
    }
}