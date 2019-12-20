package model.New_Zombies.uniqueZombie;

import model.Battle;
import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;

import java.util.ArrayList;

public class PogoZombie extends Zombie {
    public PogoZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.POGOZOMBIE);
    }

    @Override
    public <T> void action() {
        Cell cell = this.getCurrentCell();
        Map gameMap = Battle.getRunningBattle().getMap();
        if (cell.getPlant() != null) {
            for (Cell[] cells : gameMap.getCells()) {
                for (Cell c : cells) {
                    if (c.getColumn() == cell.getColumn() && c.getRow() == cell.getRow()) {
                        c.getZombies().remove(this);
                    } else if (c.getColumn() == cell.getColumn() + 1 && c.getRow() == cell.getRow()) {
                        c.getZombies().add(this);
                        setCurrentCell(c);
                        return;
                    }
                }
            }
        }
    }
}
