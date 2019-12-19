package model.New_Plants;

import constants.Constants;

import java.util.ArrayList;

public class Catapult extends Plant {

    private int speedLimiter;
    private FireRate fireRate;

    public Catapult(String plantName, int healthPoint, int attackPower,
                    int coolDown, int sunUsage, int speedLimiter, FireRate fireRate) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.CATAPULT);
        this.speedLimiter = speedLimiter;
        this.fireRate = fireRate;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }

    public int getSpeedLimiter() {
        return speedLimiter;
    }

    public FireRate getFireRate() {
        return fireRate;
    }
}
