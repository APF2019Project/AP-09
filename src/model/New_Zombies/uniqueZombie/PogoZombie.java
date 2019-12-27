package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;
import model.battle.ZombieInGame;

public class PogoZombie extends Zombie {
    public PogoZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.POGOZOMBIE);
    }

    @Override
    public <T> void action() {
        ZombieInGame zombieInGame = ZombieInGame.findZombieInGame(this);
        Cell cell = zombieInGame.getCurrentCell();
        Map gameMap = Battle.getRunningBattle().getMap();
        if (cell.getPlantInGame() != null) {
            pogoMove(gameMap, cell);
        }
    }

    public void pogoMove(Map gameMap, Cell cell) {
        ZombieInGame zombieInGame = ZombieInGame.findZombieInGame(this);
        int row = cell.getRow();
        int column = cell.getColumn();
        gameMap.getCell(row, column).getZombies().remove(zombieInGame);
        gameMap.getCell(row,column + 1).getZombies().add(zombieInGame);
        zombieInGame.setCurrentCell(gameMap.getCell(row,column + 1));
//        if(column + 1 == MAP_COLUMNS_COUNT - 1){
//
//            reachLawnMower(getCurrentCell(), gameMap);
//        }
    }

    @Override
    public void attack(Cell cell) {
        //nothing happens
    }
}
