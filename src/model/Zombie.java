public class Zombie extends Card{
    private int speed;
    private int healthPoint;
    private int attackPower;
    private int shieldHP;
    private ZombieType zombieType;
    private HelmetType helmetType;
    private TruckType truckType;
    private boolean hasHelmet;
    private boolean hasTruck;
    private boolean isBungeeZombie;
    private boolean isBalloonZombie;
    private boolean isGigaGargantuar;
    private boolean isPogoZombie;
    private boolean hasDuck;
    private boolean hasArmor;
    private boolean hasShield;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getShieldHP() {
        return shieldHP;
    }

    public void setShieldHP(int shieldHP) {
        this.shieldHP = shieldHP;
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }

    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    public boolean isHasTruck() {
        return hasTruck;
    }

    public void setHasTruck(boolean hasTruck) {
        this.hasTruck = hasTruck;
    }

    public boolean isBungeeZombie() {
        return isBungeeZombie;
    }

    public void setBungeeZombie(boolean bungeeZombie) {
        isBungeeZombie = bungeeZombie;
    }

    public boolean isBalloonZombie() {
        return isBalloonZombie;
    }

    public void setBalloonZombie(boolean balloonZombie) {
        isBalloonZombie = balloonZombie;
    }

    public boolean isGigaGargantuar() {
        return isGigaGargantuar;
    }

    public void setGigaGargantuar(boolean gigaGargantuar) {
        isGigaGargantuar = gigaGargantuar;
    }

    public boolean isPogoZombie() {
        return isPogoZombie;
    }

    public void setPogoZombie(boolean pogoZombie) {
        isPogoZombie = pogoZombie;
    }

    public boolean isHasDuck() {
        return hasDuck;
    }

    public void setHasDuck(boolean hasDuck) {
        this.hasDuck = hasDuck;
    }

    public boolean isHasArmor() {
        return hasArmor;
    }

    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }

    public boolean isHasShield() {
        return hasShield;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    public ZombieType getZombieType() {
        return zombieType;
    }

    public void setZombieType(ZombieType zombieType) {
        this.zombieType = zombieType;
    }

    public HelmetType getHelmetType() {
        return helmetType;
    }

    public void setHelmetType(HelmetType helmetType) {
        this.helmetType = helmetType;
    }

    public TruckType getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckType truckType) {
        this.truckType = truckType;
    }
}
