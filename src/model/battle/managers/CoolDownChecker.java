package model.battle.managers;

import model.New_Plants.Plant;

public class CoolDownChecker {


    private String plantName;
    private int turnCounter;
    private int plantCoolDown;

    public CoolDownChecker(String plantName, int turnCounter, int plantCoolDown) {
        this.plantName = plantName;
        this.turnCounter = turnCounter;
        this.plantCoolDown = plantCoolDown;
    }

    public boolean coolDownCheck() {
        return this.turnCounter >= this.plantCoolDown;
    }


    public String getPlantName() {
        return plantName;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void decrementTurnCounter() {
        this.turnCounter -= 1;
    }
}
