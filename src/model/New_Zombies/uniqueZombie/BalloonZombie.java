package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.New_Plants.Plant;
import model.battle.GraveYard;

import java.util.ArrayList;

public class BalloonZombie extends Zombie {
    public BalloonZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.BALLOONZOMBIE);
    }


    @Override
    public <T> void action() {
        Cell cell = this.getCurrentCell();
        attack(cell);
    }

    @Override
    public void attack(Cell cell) {
        if (cell.getPlant() != null) {
            if (cell.getPlant().getPlantKind() != PlantKind.BOMB) {
                int attackPower = this.getAttackPower();
                cell.getPlant().setHealthPoint(cell.getPlant().getHealthPoint() - attackPower);
                if (cell.getPlant().getHealthPoint() <= 0) {
                    cell.getPlant().setDead(true);
                    GraveYard.getDeadPlants().add(cell.getPlant());
                    cell.setPlant(null);
                }
            }
        }
    }
}
