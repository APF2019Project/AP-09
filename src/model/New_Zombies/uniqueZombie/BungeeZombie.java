package model.New_Zombies.uniqueZombie;

import model.Battle;
import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.GraveYard;

import java.util.ArrayList;
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
        GraveYard.getDeadPlants().add(cell.getPlant());
        cell.setPlant(null);
    }

    public void randomCell() {
        Random rand = new Random();
        int row = rand.nextInt(6);
        int column = rand.nextInt(19);
        Map gameMap = Battle.getRunningBattle().getMap();
        for (Cell[] cells : gameMap.getCells()) {
            for (Cell cell : cells) {
                if (cell.getRow() == row && cell.getColumn() == column) {
                    this.setCurrentCell(cell);
                }
            }
        }
    }
}
