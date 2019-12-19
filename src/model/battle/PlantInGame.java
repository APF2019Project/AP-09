package model.battle;

import model.Cell;
import model.New_Plants.fruits.Explosive;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.Plant;

import java.util.ArrayList;

public class PlantInGame {

    private Plant plant;
    private int turnCounter;
    private Cell currentCell;
    private ArrayList<Bullet> bullets = new ArrayList<>();

    public PlantInGame(Plant plant, int turnCounter, Cell currentCell) {
        this.plant = plant;
        this.turnCounter = turnCounter;
        this.currentCell = currentCell;
    }

    public void action() {
        //TODO must check some specific conditions
        switch (this.plant.getPlantKind()) {
            case MUSKETEER:
                musketeerAction();
                break;
            case CATAPULT:
                catapultAction();
                break;
            case BOMB:
                bombAction();
                break;
            case WALL:
                wallAction();
                break;
            case OTHER:
                otherAction();
                break;
            default:
                break;
        }
    }

    public void musketeerAction() {
        //TODO
        ArrayList<Bullet> bullets = this.plant.operate(Bullet.class);

    }

    public void catapultAction() {
        //TODO
        ArrayList<Bullet> bullets = this.plant.operate(Bullet.class);
    }

    public void bombAction() {
        //TODO
        ArrayList<Explosive> explosives = this.plant.operate(Explosive.class);
    }

    public void wallAction() {
        //TODO
    }

    public void otherAction() {
        //TODO
    }

    public void turnIncrement() {
        this.turnCounter++;
    }

    public void turnReset() {
        this.turnCounter = 0;
    }

    public Plant getPlant() {
        return plant;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }
}
