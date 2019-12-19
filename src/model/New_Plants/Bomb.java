package model.New_Plants;

import java.util.ArrayList;

public class Bomb extends Plant {

    private BombBox bombBox;

    public Bomb(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, BombBox bombBox) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.BOMB);
        this.bombBox = bombBox;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }

    public BombBox getBombBox() {
        return bombBox;
    }
}
