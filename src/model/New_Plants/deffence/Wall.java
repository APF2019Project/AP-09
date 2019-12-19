package model.New_Plants.deffence;


import model.New_Plants.Plant;
import model.New_Plants.PlantKind;

import java.util.ArrayList;

public class Wall extends Plant {


    public Wall(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.WALL);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }
}
