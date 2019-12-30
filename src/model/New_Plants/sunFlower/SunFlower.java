package model.New_Plants.sunFlower;

import model.New_Plants.Plant;
import model.New_Plants.PlantKind;
import model.New_Plants.fruits.Sun;
import model.New_Plants.warrior.FireRate;

import java.util.ArrayList;

public class SunFlower extends Plant {

    private FireRate fireRate;

    public SunFlower(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, FireRate fireRate) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.SUNFLOWER);
        this.fireRate = fireRate;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> suns = new ArrayList<>();
        Sun sun = new Sun(this.getFireRate().getBulletCount());
        suns.add(type.cast(sun));
        return suns;
    }

    public FireRate getFireRate() {
        return fireRate;
    }

    public void setFireRate(FireRate fireRate) {
        this.fireRate = fireRate;
    }
}
