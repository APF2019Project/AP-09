package model.New_Zombies.uniqueZombie;

import model.Battle;
import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;

import java.util.ArrayList;

import static constants.Constants.MAP_COLUMNS_COUNT;
import static constants.Constants.MAP_ROWS_COUNT;

public class PogoZombie extends Zombie {
    public PogoZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.POGOZOMBIE);
    }

    @Override
    public <T> void action() {
        Cell cell = this.getCurrentCell();
        Map gameMap = Battle.getRunningBattle().getMap();
        if (cell.getPlant() != null) {
            pogoMove(gameMap, cell);
        }
    }

    public void pogoMove(Map gameMap, Cell cell) {
        int row = cell.getRow();
        for (int j = 0; j < MAP_COLUMNS_COUNT; ++j) {
            if (j == cell.getColumn()) {
                gameMap.getCell(row, j).getZombies().remove(this);
            } else if (j == cell.getColumn() + 1) {
                gameMap.getCell(row, j).getZombies().add(this);
                setCurrentCell(gameMap.getCell(row, j));
                if (this.getCurrentCell().getColumn() == MAP_COLUMNS_COUNT - 1)
                    reachLawnMower(gameMap.getCell(row, j), gameMap);
                return;
            }
        }
    }

    @Override
    public void attack(Cell cell) {
        //nothing happens
    }
}
