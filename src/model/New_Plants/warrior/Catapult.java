package model.New_Plants.warrior;


import model.New_Plants.Plant;
import model.New_Plants.PlantKind;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.fruits.BulletKind;

import java.util.ArrayList;

public class Catapult extends Plant {

    private int speedLimiter;
    private FireRate fireRate;
    private int stopPower ;

    public Catapult(String plantName, int healthPoint, int attackPower,
                    int coolDown, int sunUsage, int speedLimiter, FireRate fireRate, int stopPower) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.CATAPULT);
        this.speedLimiter = speedLimiter;
        this.fireRate = fireRate;
        this.stopPower = stopPower ;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> bullets = new ArrayList<>();
        for (int i = 0; i < fireRate.getBulletCount(); i++) {
            Bullet bullet = new Bullet(BulletKind.CURVED_BULLET, this.fireRate, this.getAttackPower(), this.speedLimiter, this.stopPower);
            bullets.add(type.cast(bullet));
        }
        return bullets;
    }

    public int getSpeedLimiter() {
        return speedLimiter;
    }

    public FireRate getFireRate() {
        return fireRate;
    }

    public int getStopPower() {
        return stopPower;
    }

    public void setStopPower(int stopPower) {
        this.stopPower = stopPower;
    }
}
