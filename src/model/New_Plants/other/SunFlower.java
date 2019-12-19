package model.New_Plants.other;

import model.New_Plants.fruits.Sun;
import model.New_Plants.warrior.FireRate;

import java.util.ArrayList;

public class SunFlower extends Other {

    private FireRate fireRate;

    public SunFlower(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, FireRate fireRate) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage);
        this.fireRate = fireRate;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> suns = new ArrayList<>();
        Sun sun = new Sun(1, this.fireRate);
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
