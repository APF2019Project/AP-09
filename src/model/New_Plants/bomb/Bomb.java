package model.New_Plants.bomb;

import model.New_Plants.Plant;
import model.New_Plants.PlantKind;
import model.New_Plants.fruits.Explosive;

import java.util.ArrayList;

public class Bomb extends Plant {

    private BombBox bombBox;
    private int readyToFireCounter;

    public Bomb(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, BombBox bombBox) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.BOMB);
        this.bombBox = bombBox;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
            ArrayList<T> explosives = new ArrayList<>();
            Explosive explosive = new Explosive(this.bombBox);
            explosives.add(type.cast(explosive));
            return explosives;
        }



    public BombBox getBombBox() {
        return bombBox;
    }

    public int getReadyToFireCounter() {
        return readyToFireCounter;
    }

    public void setReadyToFireCounter(int readyToFireCounter) {
        this.readyToFireCounter = readyToFireCounter;
    }
}
