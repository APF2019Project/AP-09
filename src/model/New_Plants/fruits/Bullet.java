package model.New_Plants.fruits;

import constants.Constants;
import model.Cell;
import model.New_Plants.warrior.FireRate;
import model.battle.Battle;

import java.util.ArrayList;

public class Bullet extends Fruit {

    private int bulletSpeed = Constants.BULLET_SPEED;
    private BulletKind bulletKind;
    private FireRate fireRate;
    private int damagingPower ;
    private int speedLimiter ;
    private int radius ;

    public Bullet(BulletKind bulletKind, FireRate fireRate, int damagingPower, int speedLimiter,int radius) {
        this.bulletKind = bulletKind;
        this.fireRate = fireRate;
        this.damagingPower = damagingPower ;
        this.speedLimiter = speedLimiter ;
        this.radius = radius ;
    }


    @Override
    public <T> void action(ArrayList<T> inputs) {

    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public BulletKind getBulletKind() {
        return bulletKind;
    }

    public FireRate getFireRate() {
        return fireRate;
    }

    public void setFireRate(FireRate fireRate) {
        this.fireRate = fireRate;
    }

    public int getDamagingPower() {
        return damagingPower;
    }

    public void setDamagingPower(int damagingPower) {
        this.damagingPower = damagingPower;
    }

    public int getSpeedLimiter() {
        return speedLimiter;
    }

    public void setSpeedLimiter(int speedLimiter) {
        this.speedLimiter = speedLimiter;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
