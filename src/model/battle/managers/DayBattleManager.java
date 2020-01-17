package model.battle.managers;

import com.rits.cloning.Cloner;
import model.New_Plants.Plant;
import model.New_Zombies.Zombie;
import model.battle.Battle;
import model.battle.PlantInGame;
import model.battle.ZombieInGame;
import model.card.CardOfPlant;
import model.card.CardOfZombie;

import java.util.Random;

public class DayBattleManager extends BattleManager {

    private SunGenerator sunGenerator = new SunGenerator();


    @Override
    public void manage() {
        this.sunGenerator.generateSun();
        Battle.getRunningBattle().getBattleComponents().manage();
        this.checkForPlantsWin();
        this.checkForZombiesWin();
        Battle.getRunningBattle().incrementTurn();
        this.nextWaveCheck();
    }

    public void insertPlantCard() {
        if (Battle.getRunningBattle().checkSelectedCellIsValidForInsertPlant(Battle.getRunningBattle().getSelectedCell())) {
            if (this.insertCardValidation()) {
                Cloner cloner = new Cloner();
                Plant newPlantInGame = cloner.deepClone(((CardOfPlant) Battle.getRunningBattle().getSelectedCard()).getPlant());
                new PlantInGame(newPlantInGame, Battle.getRunningBattle().getSelectedCell());
            }
        }
    }


    private void nextWaveCheck() {
        if (Battle.getRunningBattle().getBattleComponents().getAllZombiesInGame().size() == 0) {
            Battle.getRunningBattle().decrementWavesCount();
            this.insertNextWaveZombies();
        }
    }

    private void insertNextWaveZombies() {
        Random random = new Random();
        int zombiesCount = random.nextInt(7) + 4;
        for (int i = 0; i < zombiesCount; i++) {
            generateRandomZombie();
        }
    }

    private void generateRandomZombie() {
        Random random = new Random();
        int randomRow = random.nextInt(6);
        int randomCard = random.nextInt(Battle.getRunningBattle().getZombies().getDeck().size());
        Zombie zombie = ((CardOfZombie) Battle.getRunningBattle().getZombies().getDeck().get(randomCard)).getZombie();
        Cloner cloner = new Cloner();
        Zombie newRandomZombie = cloner.deepClone(zombie);
        new ZombieInGame(newRandomZombie, Battle.getRunningBattle().getMap().getCell(randomRow, 18));
    }


    private boolean insertCardValidation() {
        if (coolDownCheck(((CardOfPlant) Battle.getRunningBattle().getSelectedCard()).getPlant())) {
            if (Battle.getRunningBattle().getSelectedCell().getColumn() % 2 == 1) {
                if (Battle.getRunningBattle().getPlants().getSun() >= ((CardOfPlant) Battle.getRunningBattle().getSelectedCard()).getPlant().getSunUsage())
                    return true;
                else {
                    System.out.println("Not Enough Sun!");
                    return false;
                }
            } else {
                System.out.println("Plants Can be planted on odd columns only!");
                return false;
            }
        }
        System.out.println("CoolDown time!");
        return false;
    }

    private boolean coolDownCheck(Plant plant) {
        for (CoolDownChecker coolDownChecker : Battle.getRunningBattle().getCoolDownCheckers()) {
            if (coolDownChecker.getPlantName().equals(plant.getPlantName())) {
                return coolDownChecker.coolDownCheck();
            }
        }
        return false;
    }


}
