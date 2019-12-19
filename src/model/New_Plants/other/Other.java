package model.New_Plants.other;

import model.New_Plants.Plant;
import model.New_Plants.PlantKind;

import java.util.ArrayList;

public class Other extends Plant {

    public Other(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.OTHER);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }
}
