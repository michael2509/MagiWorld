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

    public void setLevelAndLifePoints(int level) {
        this.level = level;
        this.lifePoints = level * 5;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
