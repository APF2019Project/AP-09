package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
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
        if (cell.getPlantInGame() != null) {
            if (cell.getPlantInGame().getPlant().getPlantKind() != PlantKind.BOMB) {
                int attackPower = this.getAttackPower();
                cell.getPlantInGame().getPlant().setHealthPoint(cell.getPlantInGame().getPlant().getHealthPoint() - attackPower);
                if (cell.getPlantInGame().getPlant().getHealthPoint() <= 0) {
                    cell.getPlantInGame().getPlant().setDead(true);
                }
            }
        }
    }
}
