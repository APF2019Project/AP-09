package model;

import java.util.ArrayList;

public class Zombie extends Card {
    private static ArrayList<Zombie> zombies = new ArrayList<>();
    private String zombieName ;
    private String zombieId = null;
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

    public Zombie() {
        zombies.add(this);
    }

    public Zombie(String zombieName, int speed, int healthPoint, int attackPower, int shieldHP, ZombieType zombieType, HelmetType helmetType,
                  TruckType truckType, boolean hasHelmet, boolean hasTruck, boolean isBungeeZombie, boolean isBalloonZombie,
                  boolean isGigaGargantuar, boolean isPogoZombie, boolean hasDuck, boolean hasArmor, boolean hasShield) {
        this.zombieName = zombieName ;
        this.speed = speed;
        this.healthPoint = healthPoint;
        this.attackPower = attackPower;
        this.shieldHP = shieldHP;
        this.zombieType = zombieType;
        this.helmetType = helmetType;
        this.truckType = truckType;
        this.hasHelmet = hasHelmet;
        this.hasTruck = hasTruck;
        this.isBungeeZombie = isBungeeZombie;
        this.isBalloonZombie = isBalloonZombie;
        this.isGigaGargantuar = isGigaGargantuar;
        this.isPogoZombie = isPogoZombie;
        this.hasDuck = hasDuck;
        this.hasArmor = hasArmor;
        this.hasShield = hasShield;
        zombies.add(this);
    }


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

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public String getZombieName() {
        return zombieName;
    }

    public void setZombieName(String zombieName) {
        this.zombieName = zombieName;
    }


    public String getZombieId() {
        return zombieId;
    }

    public void setZombieId(String zombieId) {
        this.zombieId = zombieId;
    }
}