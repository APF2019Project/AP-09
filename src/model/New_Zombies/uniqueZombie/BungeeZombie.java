package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;
import model.battle.GraveYard;
import model.battle.PlantInGame;
import model.battle.ZombieInGame;

import java.util.Random;

public class BungeeZombie extends Zombie {
    public int turnCounter = 0;

    public BungeeZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.BUNGEEZOMBIE);
    }

    @Override
    public <T> void action() {
        ZombieInGame zombieInGame = ZombieInGame.findZombieInGame(this);
        if (turnCounter == 0)
            this.randomCell(zombieInGame);
        Cell cell = zombieInGame.getCurrentCell();
        if (turnCounter == 3) {
            attack(cell);
            turnCounter = 0;
        } else
            ++turnCounter;
    }

    @Override
    public void attack(Cell cell) {
        cell.getPlantInGame().getPlant().setDead(true);
    }

    public void randomCell(ZombieInGame zombieInGame) {
        Random rand = new Random();
        int randomPlantNumber = rand.nextInt(Battle.getRunningBattle().getBattleComponents().getAllPlantsInGame().size());
        PlantInGame randomPlantInGame = Battle.getRunningBattle().getBattleComponents().getAllPlantsInGame().get(randomPlantNumber);
        Cell bungeeCell = randomPlantInGame.getCurrentCell();
        zombieInGame.setCurrentCell(bungeeCell);
    }
}
