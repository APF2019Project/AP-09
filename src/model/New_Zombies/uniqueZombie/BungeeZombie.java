package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;
import model.battle.GraveYard;

import java.util.Random;

public class BungeeZombie extends Zombie {
    public int turnCounter = 0;

    public BungeeZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.BUNGEEZOMBIE);
    }

    @Override
    public <T> void action() {
        Cell cell = this.getCurrentCell();
        if (turnCounter == 3) {
            attack(cell);
            turnCounter = 0;
        } else
            ++turnCounter;
    }

    @Override
    public void attack(Cell cell) {
        cell.getPlant().setDead(true);
        GraveYard.getDeadPlants().add(cell.getPlant());
        cell.setPlant(null);
    }

    public void randomCell() {
        Random rand = new Random();
        int row = rand.nextInt(6);
        int column = rand.nextInt(19);
        Map gameMap = Battle.getRunningBattle().getMap();
        Cell bungeeCell = gameMap.getCell(row , column);
        setCurrentCell(bungeeCell);
    }
}
