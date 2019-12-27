package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.GraveYard;
import model.battle.ZombieInGame;

public class TruckZombie extends Zombie {
    private boolean hasStrongTruck;

    public TruckZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor, boolean hasStrongTruck) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.TRUCKZOMBIE);
        setHasStrongTruck(hasStrongTruck);
    }

    public boolean hasStrongTruck() {
        return hasStrongTruck;
    }


    public void setHasStrongTruck(boolean hasStrongTruck) {
        this.hasStrongTruck = hasStrongTruck;
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
                cell.getPlantInGame().getPlant().setDead(true);
            }
        }
    }

    /*
    public void truckDeath(){
        if(hasStrongTruck){
            this.setZombieName("Zombie");
            this.setHealthPoint(2);
            this.setAttackPower(1);
            this.setSpeed(2);
            this.setZombieKind(ZombieKind.OTHER);
        }
        else{
           TRUCK ZOMBIE DIES
           passing it to GraveYard
        }
    }
    */

}
