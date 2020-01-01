package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Plants.PlantKind;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;
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
        Map gameMap = Battle.getRunningBattle().getMap();
        int row = cell.getRow();
        int column = cell.getColumn();
        if (gameMap.getCell(row, column + 1) != null) {
            if (gameMap.getCell(row, column + 1).getPlantInGame().getPlant().getPlantKind() != PlantKind.BOMB) {
                gameMap.getCell(row, column + 1).getPlantInGame().getPlant().setDead(true);
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
            this.setDead(false);
        }
        else{
           TRUCK ZOMBIE DIES
           passing it to GraveYard
        }
    }
    */

}
