package model.New_Zombies.uniqueZombie;

import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;

import java.util.ArrayList;

public class BungeeZombie extends Zombie {
    public BungeeZombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.BUNGEEZOMBIE);
    }

    @Override
    public <T> ArrayList<T> operate(Class<T> type) {
        return null;
    }
}
