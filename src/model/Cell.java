package model;

import java.util.ArrayList;

public class Cell {
    private int row;
    private int column;
    private Plant1 plant1;
    private ArrayList<Zombie1> zombies = new ArrayList<Zombie1>();
    private boolean hasPlant;
    private boolean hasZombie;
    private boolean isLand;
    private boolean leaf;

    public boolean hasZombie() {
        return hasZombie;
    }

    public void setHasZombie(boolean hasZombie) {
        this.hasZombie = hasZombie;
    }

    public boolean hasPlant() {
        return hasPlant;
    }

    public void setHasPlant(boolean hasPlant) {
        this.hasPlant = hasPlant;
    }

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

    public ArrayList<Zombie1> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie1> zombies) {
        this.zombies = zombies;
    }

    public Plant1 getPlant1() {
        return plant1;
    }

    public void setPlant1(Plant1 plant1) {
        this.plant1 = plant1;
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
}
