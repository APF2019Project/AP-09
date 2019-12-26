package model.New_Zombies.other;

import model.Cell;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.GraveYard;

public class Other extends Zombie {
    private HelmetType helmetType;

    public Other(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor, HelmetType helmetType) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.OTHER);
        setHelmetType(helmetType);
    }

    public HelmetType getHelmetType() {
        return helmetType;
    }

    public void setHelmetType(HelmetType helmetType) {
        this.helmetType = helmetType;
    }


    @Override
    public <T> void action() {
        Cell cell = this.getCurrentCell();
        attack(cell);
    }

    @Override
    public void attack(Cell cell) {
        if (cell.getPlantInGame() != null) {
            if (cell.getPlantInGame().getPlantKind() != PlantKind.BOMB) {
                int attackPower = this.getAttackPower();
                cell.getPlantInGame().setHealthPoint(cell.getPlantInGame().getHealthPoint() - attackPower);
                if (cell.getPlantInGame().getHealthPoint() <= 0) {
                    cell.getPlantInGame().setDead(true);
                    GraveYard.getDeadPlants().add(cell.getPlantInGame());
                    cell.setPlantInGame(null);
                }
            }
        }
    }
}
