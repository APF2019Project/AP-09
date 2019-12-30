package model.battle;

import java.util.Random;

public class SunGenerator {

    private Random random = new Random();
    private int randomTurn;
    private int turnCounter;

    public void generateSun() {
        if (this.turnCounter == this.randomTurn) {
            this.generateRandomSunCount();
            this.randomTurnGenerator();
            this.turnCounter = 0;
        } else {
            this.turnCounter += 1;
        }

    }

    private void randomTurnGenerator() {
        this.randomTurn = 1 + this.random.nextInt(2);
    }

    private void generateRandomSunCount() {
        int randomSunCount = 2 + this.random.nextInt(4);
        Battle.getRunningBattle().increasePlantsSun(randomSunCount);
    }

}
