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
    public void Given_ValueIsOne_When_AskingToChooseClass_Then_CreatePlayerWithWarriorClass() {
        setInValues("1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        assertTrue(playerCreator.getPlayer() instanceof Warrior);
    }

    @Test
    public void Given_ValueIsTwo_When_AskingToChooseClass_Then_CreatePlayerWithArcherClass() {
        setInValues("2");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        assertTrue(playerCreator.getPlayer() instanceof Archer);
    }

    @Test
    public void Given_ValueIsThree_When_AskingToChooseClass_Then_CreatePlayerWithMageClass() {
        setInValues("3");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        assertTrue(playerCreator.getPlayer() instanceof Mage);
    }
}