package model.New_Plants.fruits;

import constants.Constants;
import model.Cell;
import model.Map;
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
        this.setPosition(Map.getCurrentMap().getCell(this.getPosition().getRow() + this.radius , this.getPosition().getColumn()));
        for (int i = 0; i < bulletSpeed + 1 ; i++) {
            if (this.getPosition().getZombies() != null ){
                /* todo inja age zombies.get(0) shield dasht va noe bullet az noe straight bood az shieldesh kam kon age nadasht az joonesh kam kon age az noe curved bood yekarast boro az joone zombi kam kon
                    age zobie joonesh sefr shod az arrayliste cell va arrayliste zombiesingame removesh kon
                    emal kardane speed limit rooye zombi baraye ye nobat
                 */
                Battle.getRunningBattle().getBattleComponents().getFruits().remove(this) ;
                this.getPosition().getFruits().remove(this);
            }else {
                if (this.getPosition().getColumn() == Constants.MAP_COLUMNS_COUNT - 1 ){
                    Battle.getRunningBattle().getBattleComponents().getFruits().remove(this) ;
                    this.getPosition().getFruits().remove(this);
                }else
                this.setPosition(Map.getCurrentMap().getCell(this.getPosition().getRow(), this.getPosition().getColumn() + 1));
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
