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
    public void Given_GoodValue_When_AskingToChooseClass_Then_CreatePlayerWithCorrectClass() {
        setInValues("1");

        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayer();

        assertTrue(playerCreator.getPlayer() instanceof Warrior);
    }
}