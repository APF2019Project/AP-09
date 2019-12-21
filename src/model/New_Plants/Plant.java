package model.New_Plants;

import java.util.ArrayList;

abstract public class Plant {

    private static ArrayList<Plant> plants = new ArrayList<>();
    private String plantName;
    private int healthPoint;
    private int attackPower;
    private int coolDown;
    private int sunUsage;
    private PlantKind plantKind;

    public Plant(String plantName, int healthPoint, int attackPower, int coolDown, int sunUsage, PlantKind plantKind) {
        this.plantName = plantName;
        this.healthPoint = healthPoint;
        this.attackPower = attackPower;
        this.coolDown = coolDown;
        this.sunUsage = sunUsage;
        this.plantKind = plantKind;
    }

    abstract public <T> ArrayList<T> operate(Class<T> type);

    public String getPlantName() {
        return plantName;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public int getSunUsage() {
        return sunUsage;
    }

    public PlantKind getPlantKind() {
        return plantKind;
    }
}
