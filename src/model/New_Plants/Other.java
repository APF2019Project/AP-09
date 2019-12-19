package model.New_Plants;

import java.util.ArrayList;

public class Other extends Plant {

    public Other(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage){
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.OTHER);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }
}
