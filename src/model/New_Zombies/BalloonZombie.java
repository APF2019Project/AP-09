package model.New_Zombies;

import java.util.ArrayList;

public class BalloonZombie extends Zombie {
    public BalloonZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.BALLOONZOMBIE);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }
}
