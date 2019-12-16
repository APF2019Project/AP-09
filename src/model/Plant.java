package model;

import java.util.ArrayList;

public class Plant extends Card {
    private static ArrayList<Plant> plants = new ArrayList<>();
    private String plantName ;
    private String plantId = null;
    private int plantedTurn;
    private int healthPoint;
    private int attackPower;
    private int coolDown;
    private int sunUsage;
    private PlantType plantType;
    private BulletType bulletType;
    private BombType bombType;
    private NutType nutType;
    private SunflowerType sunflowerType;
    private boolean hasBullet;
    private boolean isBomb;
    private boolean isNut;
    private boolean isSunflower;
    private boolean isSnowy;
    private boolean doesFreeze;
    private boolean isCactus;
    private boolean isScared;
    private boolean isLilyPad;
    private boolean isTangleKelp;
    private boolean isCattail;
    private boolean hasMagnet;

    public Plant(){
        plants.add(this);
    }

    public Plant(String plantName, int plantedTurn, int healthPoint, int attackPower, int coolDown, int sunUsage, PlantType plantType,
                 BulletType bulletType, BombType bombType, NutType nutType, SunflowerType sunflowerType,
                 boolean hasBullet, boolean isBomb, boolean isNut, boolean isSunflower, boolean isSnowy, boolean doesFreeze,
                 boolean isCactus, boolean isScared, boolean isLilyPad, boolean isTangleKelp, boolean isCattail,
                 boolean hasMagnet) {
        this.plantName = plantName ;
        this.plantedTurn = plantedTurn;
        this.healthPoint = healthPoint;
        this.attackPower =attackPower;
        this.coolDown =coolDown;
        this.sunUsage = sunUsage;
        this.plantType = plantType;
        this.bulletType = bulletType;
        this.bombType = bombType;
        this.nutType = nutType;
        this.sunflowerType =sunflowerType;
        this.hasBullet = hasBullet;
        this.isBomb = isBomb;
        this.isNut = isNut;
        this.isSunflower = isSunflower;
        this.isSnowy = isSnowy;
        this.doesFreeze = doesFreeze;
        this.isCactus = isCactus;
        this.isScared = isScared;
        this.isLilyPad = isLilyPad;
        this.isTangleKelp = isTangleKelp;
        this.isCattail = isCattail;
        this.hasMagnet = hasMagnet;
        plants.add(this);
    }

    public int getPlantedTurn() {
        return plantedTurn;
    }

    public void setPlantedTurn(int plantedTurn) {
        this.plantedTurn = plantedTurn;
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

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getSunUsage() {
        return sunUsage;
    }

    public void setSunUsage(int sunUsage) {
        this.sunUsage = sunUsage;
    }

    public boolean isHasBullet() {
        return hasBullet;
    }

    public void setHasBullet(boolean hasBullet) {
        this.hasBullet = hasBullet;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isNut() {
        return isNut;
    }

    public void setNut(boolean nut) {
        isNut = nut;
    }

    public boolean isSunflower() {
        return isSunflower;
    }

    public void setSunflower(boolean sunflower) {
        isSunflower = sunflower;
    }

    public boolean isSnowy() {
        return isSnowy;
    }

    public void setSnowy(boolean snowy) {
        isSnowy = snowy;
    }

    public boolean isDoesFreeze() {
        return doesFreeze;
    }

    public void setDoesFreeze(boolean doesFreeze) {
        this.doesFreeze = doesFreeze;
    }

    public boolean isCactus() {
        return isCactus;
    }

    public void setCactus(boolean cactus) {
        isCactus = cactus;
    }

    public boolean isScared() {
        return isScared;
    }

    public void setScared(boolean scared) {
        isScared = scared;
    }

    public boolean isLilyPad() {
        return isLilyPad;
    }

    public void setLilyPad(boolean lilyPad) {
        isLilyPad = lilyPad;
    }

    public boolean isTangleKelp() {
        return isTangleKelp;
    }

    public void setTangleKelp(boolean tangleKelp) {
        isTangleKelp = tangleKelp;
    }

    public boolean isCattail() {
        return isCattail;
    }

    public void setCattail(boolean cattail) {
        isCattail = cattail;
    }

    public boolean isHasMagnet() {
        return hasMagnet;
    }

    public void setHasMagnet(boolean hasMagnet) {
        this.hasMagnet = hasMagnet;
    }

    public SunflowerType getSunflowerType() {
        return sunflowerType;
    }

    public void setSunflowerType(SunflowerType sunflowerType) {
        this.sunflowerType = sunflowerType;
    }

    public NutType getNutType() {
        return nutType;
    }

    public void setNutType(NutType nutType) {
        this.nutType = nutType;
    }

    public BombType getBombType() {
        return bombType;
    }

    public void setBombType(BombType bombType) {
        this.bombType = bombType;
    }

    public BulletType getBulletType() {
        return bulletType;
    }

    public void setBulletType(BulletType bulletType) {
        this.bulletType = bulletType;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public static ArrayList<Plant> getPlants() {
        return plants;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }
}