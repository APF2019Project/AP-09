package model.New_Plants.fruits;

import constants.Constants;
import model.Cell;
import model.New_Plants.warrior.FireRate;

import java.util.ArrayList;

public class Bullet extends Fruit {

    private int bulletSpeed = Constants.BULLET_SPEED;
    private BulletKind bulletKind;
    private FireRate fireRate;
    private int damagingPower ;


    public Bullet(BulletKind bulletKind, FireRate fireRate, int damagingPower) {
        this.bulletKind = bulletKind;
        this.fireRate = fireRate;

    }


    @Override
    public <T> void action(ArrayList<T> inputs) {
        // TODO if there is a zombie in this bullet position, that zombie should be damaged
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

}
