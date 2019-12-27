package model.New_Plants.deffence;


import model.New_Plants.Plant;
import model.New_Plants.PlantKind;

import java.util.ArrayList;

public class Wall extends Plant {
    private int physicalAttack ;


    public Wall(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage,int physicalAttack) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.WALL);
        this.physicalAttack = physicalAttack ;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }
}
