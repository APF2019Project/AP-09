package model.New_Plants.other;

import java.util.ArrayList;

public class Magnetic extends Other {


    public Magnetic(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> magnets = new ArrayList<>();
        Magnet magnet = new Magnet();
        magnets.add(type.cast(magnet));
        return magnets;
    }
}
