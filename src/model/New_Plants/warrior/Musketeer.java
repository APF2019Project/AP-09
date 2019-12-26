package model.New_Plants.warrior;

import model.New_Plants.Plant;
import model.New_Plants.PlantKind;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.fruits.BulletKind;

import java.util.ArrayList;

public class Musketeer extends Plant {
    private FireRate fireRate;
    private int speedLimiter;
    private  int rangeOfAttack ;
    private int physicalAttack ;

    public Musketeer(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, int speedLimiter, FireRate fireRate, int rangeOfAttack, int physicalAttack) {
        super(plantName, healthPoint, attackPower, coolDown, sunUsage, PlantKind.MUSKETEER);
        this.speedLimiter = speedLimiter;
        this.fireRate = fireRate;
        this.rangeOfAttack = rangeOfAttack ;
        this.physicalAttack = physicalAttack ;
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        ArrayList<T> bullets = new ArrayList<>();
        for (int i = 0; i < this.fireRate.getBulletCount(); i++) {
            if (this.rangeOfAttack !=0 ) {
                for (int j = -this.rangeOfAttack; j < this.rangeOfAttack + 1; j++) {
                    Bullet bullet = new Bullet(BulletKind.STRAIGHT_BULLET, this.fireRate, 1, this.speedLimiter, j);
                    bullets.add(type.cast(bullet));
                }
            }
            else {
                Bullet bullet = new Bullet(BulletKind.STRAIGHT_BULLET, this.fireRate, 1, this.speedLimiter, 0);
                bullets.add(type.cast(bullet));
            }

        }
        return bullets;
    }


    public FireRate getFireRate() {
        return fireRate;
    }

    public int getSpeedLimiter() {
        return speedLimiter;
    }

    public int getRangeOfAttack() {
        return rangeOfAttack;
    }

    public void setRangeOfAttack(int rangeOfAttack) {
        this.rangeOfAttack = rangeOfAttack;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }
}


