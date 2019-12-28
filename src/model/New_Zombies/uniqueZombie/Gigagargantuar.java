package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;
import model.battle.GraveYard;
import model.battle.ZombieInGame;

public class Gigagargantuar extends Zombie {
    public Gigagargantuar(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.GIGAGARGANTUAR);
    }

    @Override
    public <T> void action() {
        ZombieInGame zombieInGame = ZombieInGame.findZombieInGame(this);
        Cell cell = zombieInGame.getCurrentCell();
        attack(cell);
    }

    @Override
    public void attack(Cell cell) {
        Map gameMap = Battle.getRunningBattle().getMap();
        int row = cell.getRow();
        int column = cell.getColumn();
        if (gameMap.getCell(row , column + 1).getPlantInGame() != null) {
            if (gameMap.getCell(row , column + 1).getPlantInGame().getPlant().getPlantKind() != PlantKind.BOMB) {
                gameMap.getCell(row , column + 1).getPlantInGame().getPlant().setDead(true);
            }
        }
    }
}
