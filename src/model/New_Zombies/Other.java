package model.New_Zombies;

public class Other extends Zombie {
    private HelmetType helmetType;
    public Other(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor) {
        super(zombieName, healthPoint, attackPower, speed, shieldHP, isLandZombie, hasDuck, hasHelmet, hasArmor, ZombieKind.OTHER);
        setHelmetType(helmetType);
    }

    public HelmetType getHelmetType() {
        return helmetType;
    }

    public void setHelmetType(HelmetType helmetType) {
        this.helmetType = helmetType;
    }
}
