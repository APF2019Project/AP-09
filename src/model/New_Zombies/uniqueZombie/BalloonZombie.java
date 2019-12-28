package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;
import model.battle.GraveYard;
import model.battle.ZombieInGame;

public class BalloonZombie extends Zombie {
    public BalloonZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.BALLOONZOMBIE);
    }


    @Override
    public <T> void action() {
        ZombieInGame zombieInGame = ZombieInGame.findZombieInGame(this);
        Cell cell = zombieInGame.getCurrentCell();
        attack(cell);
    }

    @Override
    public void attack(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        Map gameMap = Battle.getRunningBattle().getMap();
        if (gameMap.getCell(row, column + 1).getPlantInGame() != null) {
            if (gameMap.getCell(row, column + 1).getPlantInGame().getPlant().getPlantKind() != PlantKind.BOMB) {
                int attackPower = this.getAttackPower();
                gameMap.getCell(row, column + 1).getPlantInGame().getPlant().setHealthPoint(gameMap.getCell(row, column + 1).getPlantInGame().getPlant().getHealthPoint() - attackPower);
                if (gameMap.getCell(row, column + 1).getPlantInGame().getPlant().getHealthPoint() <= 0) {
                    gameMap.getCell(row, column + 1).getPlantInGame().getPlant().setDead(true);
                }
            }
        }
    }
}
