package model.New_Plants.warrior;

import model.New_Plants.Plant;
import model.New_Plants.PlantKind;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.fruits.BulletKind;

import java.util.ArrayList;

public class Musketeer extends Plant {
    private FireRate fireRate;
    private int speedLimiter;

    public Musketeer(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, int speedLimiter, FireRate fireRate) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.MUSKETEER);
        this.speedLimiter = speedLimiter;
        this.fireRate = fireRate;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> bullets = new ArrayList<>();
        for (int i = 0; i < this.fireRate.getBulletCount(); i++) {
            Bullet bullet = new Bullet(BulletKind.STRAIGHT_BULLET, this.fireRate);
            bullets.add(type.cast(bullet));
        }
        return bullets;
    }

    public FireRate getFireRate() {
        return fireRate;
    }

    public int getSpeedLimiter() {
        return speedLimiter;
    }
}


