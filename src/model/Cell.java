package model;

import model.New_Plants.*;
import model.New_Plants.fruits.Fruit;
import model.New_Zombies.Zombie;
import model.battle.ZombieInGame;

import java.util.ArrayList;

public class Cell {
    private int row;
    private int column;
    private Plant plant;
    private ArrayList<ZombieInGame> zombies = new ArrayList<ZombieInGame>();
    private ArrayList<Fruit> fruits = new ArrayList<>();
    private boolean isLand;
    private boolean leaf;

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isLand() {
        return isLand;
    }

    public void setLand(boolean land) {
        isLand = land;
    }

    public ArrayList<ZombieInGame> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<ZombieInGame> zombies) {
        this.zombies = zombies;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plants) {
        plant = plants;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
}
