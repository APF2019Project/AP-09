package model.New_Plants.fruits;

import constants.Constants;
import model.Cell;
import model.Map;
import model.New_Plants.warrior.FireRate;
import model.battle.Battle;
import model.battle.GraveYard;
import model.battle.ZombieInGame;

import java.util.ArrayList;

public class Bullet extends Fruit {

    private int bulletSpeed = Constants.BULLET_SPEED;
    private BulletKind bulletKind;
    private FireRate fireRate;
    private int damagingPower;
    private int speedLimiter;
    private int radius;

    public Bullet(BulletKind bulletKind, FireRate fireRate, int damagingPower, int speedLimiter, int radius) {
        this.bulletKind = bulletKind;
        this.fireRate = fireRate;
        this.damagingPower = damagingPower;
        this.speedLimiter = speedLimiter;
        this.radius = radius;
    }


    @Override
    public <T> void action(ArrayList<T> inputs) {
        this.setPosition(Map.getCurrentMap().getCell(this.getPosition().getRow() + this.radius, this.getPosition().getColumn()));
        for (int i = 0; i < bulletSpeed + 1; i++) {
            if (this.getPosition().getZombies() != null) {
                if (BulletKind.STRAIGHT_BULLET == bulletKind) {
                    this.getPosition().getZombies().get(0).getZombie().decreaseZombieHealthStraight(damagingPower);
                    if (speedLimiter > 0) {
                        this.getPosition().getZombies().get(0).getZombie().setSpeedLimited(speedLimiter);
                    }
                } else if (BulletKind.CURVED_BULLET == bulletKind) {
                    this.getPosition().getZombies().get(0).getZombie().decreaseZombieHealthCurve(damagingPower);
                    if (speedLimiter > 0) {
                        this.getPosition().getZombies().get(0).getZombie().setSpeedLimited(speedLimiter);
                    }
                }
                if (this.getPosition().getZombies().get(0).getZombie().getHealthPoint() <= 0) {
                    GraveYard.getDeadZombies().add(this.getPosition().getZombies().get(0).getZombie());
                    ZombieInGame.removeZombieFromGame(this.getPosition().getZombies().get(0));
                    this.getPosition().getZombies().remove(0);
                }
                Battle.getRunningBattle().getBattleComponents().getFruits().remove(this);
                this.getPosition().getFruits().remove(this);
            } else {
                if (this.getPosition().getColumn() == Constants.MAP_COLUMNS_COUNT - 1) {
                    Battle.getRunningBattle().getBattleComponents().getFruits().remove(this);
                    this.getPosition().getFruits().remove(this);
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
}
