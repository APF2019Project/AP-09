package model.New_Plants.fruits;

import model.Cell;

import java.util.ArrayList;

abstract public class Fruit {

    private Cell position;
    private boolean isDead ;

    public Fruit() {
    }

    abstract public <T> void action(ArrayList<T> inputs);


    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
