package model.New_Plants.fruits;

import model.constants.Constants;
import model.Map;
import model.New_Plants.warrior.FireRate;

import java.util.ArrayList;

public class Bullet extends Fruit {

    private int bulletSpeed = Constants.BULLET_SPEED;
    private BulletKind bulletKind;
    private FireRate fireRate;
    private int damagingPower;
    private int speedLimiter;
    private int radius;
    private int stopPower ;

    public Bullet(BulletKind bulletKind, FireRate fireRate, int damagingPower, int speedLimiter, int stopPower) {
        this.bulletKind = bulletKind;
        this.fireRate = fireRate;
        this.damagingPower = damagingPower;
        this.speedLimiter = speedLimiter;
        this.stopPower = stopPower ;
    }


    @Override
    public <T> void action(ArrayList<T> inputs) {
        this.setPosition(Map.getCurrentMap().getCell(this.getPosition().getRow() + this.radius, this.getPosition().getColumn()));
        for (int i = 0; i < bulletSpeed + 1; i++) {
            if (this.getPosition().getZombies() != null) {
                if (BulletKind.STRAIGHT_BULLET == bulletKind) {
                    int counter =0 ;
                    while (counter<this.getPosition().getZombies().size()){
                        if (!this.getPosition().getZombies().get(counter).getZombie().getZombieName().equals("BalloonZombie")){
                            this.getPosition().getZombies().get(counter).getZombie().decreaseZombieHealthStraight(damagingPower);
                            if (speedLimiter > 0) {
                                this.getPosition().getZombies().get(counter).getBulletEffect().setSpeedLimit(speedLimiter);
                            }
                            if (this.getPosition().getZombies().get(counter).getZombie().getHealthPoint() <= 0) {
                                this.getPosition().getZombies().get(counter).getZombie().setDead(true);
                            }
                            this.setDead(true);
                            return;
                        } else
                            counter++ ;
                        }
                    }else if (BulletKind.CURVED_BULLET == bulletKind) {
                    this.getPosition().getZombies().get(0).getZombie().decreaseZombieHealthCurve(damagingPower);
                    if (speedLimiter > 0) {
                        this.getPosition().getZombies().get(0).getBulletEffect().setSpeedLimit(speedLimiter);
                    }
                    if (this.getPosition().getZombies().get(0).getZombie().getHealthPoint() <= 0) {
                        this.getPosition().getZombies().get(0).getZombie().setDead(true);
                    }
                    this.setDead(true);
                }


                } else {
                if (this.getPosition().getColumn() == Constants.MAP_COLUMNS_COUNT - 1) {
                    this.setDead(true);
                }else
                    this.getPosition().getFruits().remove(this);
                this.setPosition(Map.getCurrentMap().getCell(this.getPosition().getRow(), this.getPosition().getColumn() + 1));
                this.getPosition().getFruits().add(this);
            }
        }

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

    public int getStopPower() {
        return stopPower;
    }

    public void setStopPower(int stopPower) {
        this.stopPower = stopPower;
    }
}
