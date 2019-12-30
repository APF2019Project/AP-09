package model.New_Plants.magnetic;

import model.New_Plants.Plant;
import model.New_Plants.PlantKind;


import java.util.ArrayList;

public class Magnetic extends Plant {


    public Magnetic(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.MAGNETIC);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> magnets = new ArrayList<>();
        Magnet magnet = new Magnet();
        magnets.add(type.cast(magnet));
        return magnets;
    }
}
