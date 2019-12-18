package model;

import java.util.ArrayList;

public class Cell {
    private int row;
    private int column;
    private Plant plant;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
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

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
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
