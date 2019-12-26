package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.GraveYard;

public class Gigagargantuar extends Zombie {
    public Gigagargantuar(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.GIGAGARGANTUAR);
    }

    @Override
    public <T> void action() {
        Cell cell = this.getCurrentCell();
        attack(cell);
    }

    @Override
    public void attack(Cell cell) {
        if (cell.getPlantInGame() != null) {
            if (cell.getPlantInGame().getPlant().getPlantKind() != PlantKind.BOMB) {
                cell.getPlantInGame().getPlant().setDead(true);
            }
        }
    }
}
