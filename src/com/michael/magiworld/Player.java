package com.michael.magiworld;

public class Player {
    private int level;
    private int lifePoints;
    private int strength;
    private int agility;
    private int intelligence;

    public int getLevel() {
        return level;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setLevelAndLifePoints(int value) {
        level = value;
        lifePoints = level * 5;
    }

    public void setStrength(int value) {
        strength = value;
    }

    public void setAgility(int value) {
        agility = value;
    }

    public void setIntelligence(int value) {
        intelligence = value;
    }
}
