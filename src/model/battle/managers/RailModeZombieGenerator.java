package model.battle.managers;

import com.rits.cloning.Cloner;
import model.New_Zombies.Zombie;
import model.battle.Battle;
import model.battle.ZombieInGame;

import java.util.Random;

public class RailModeZombieGenerator {

    private Random random = new Random();
    private int randomTurn;
    private int turnCounter;

    public void generateZombie() {
        if (this.randomTurn == this.turnCounter){
            this.generateRandomZombie();
            this.randomTurnGenerator();
            this.turnCounter = 0;

        }else{
            this.turnCounter += 1;
        }

    }

    private void randomTurnGenerator() {
        this.randomTurn = 3 + this.random.nextInt(3);
    }

    private void generateRandomZombie() {
        int randomIndex = this.random.nextInt(Zombie.getZombies().size());
        Cloner cloner = new Cloner();
        Zombie zombie = cloner.deepClone(Zombie.getZombies().get(randomIndex));
        int randomRow = random.nextInt(6);
        new ZombieInGame(zombie, Battle.getRunningBattle().getMap().getCell(randomRow, 18));
    }

}
