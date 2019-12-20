package model.New_Zombies.uniqueZombie;

import model.Cell;
import model.Map;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.battle.Battle;

import java.util.ArrayList;

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
        Cell cell = this.getCurrentCell();
        if (cell.getPlant() != null) {
            //Kill Plant
        }
    }

    @Override
    public void move() {
        Cell cell = this.getCurrentCell();
        Map gameMap = Battle.getRunningBattle().getMap();
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
    /*
    public void truckDeath(){
        if(hasStrongTruck){
            this.setHealthPoint(2);
            this.setAttackPower(1);
            this.setSpeed(2);
            this.setZombieKind(ZombieKind.OTHER);
            setHasStrongTruck(false);
        }
        else{
           TRUCK ZOMBIE DIES
           passing it to GraveYard
        }
    }
    */
}