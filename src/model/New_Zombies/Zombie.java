package model.New_Zombies;

import model.Cell;
import model.Map;
import model.battle.Battle;
import constants.Constants;

import java.util.ArrayList;

import static constants.Constants.MAP_COLUMNS_COUNT;
import static constants.Constants.MAP_ROWS_COUNT;

abstract public class Zombie {
    private static ArrayList<Zombie> zombies = new ArrayList<>();
    private String zombieName;
    private int healthPoint;
    private int attackPower;
    private int speed;
    private int shieldHP;
    private boolean isLandZombie;
    private boolean hasDuck;
    private boolean hasHelmet;
    private boolean hasArmor;
    private ZombieKind zombieKind;
    private Cell currentCell;

    public Zombie(String zombieName, int healthPoint, int attackPower, int speed, int shieldHP, boolean isLandZombie, boolean hasDuck, boolean hasHelmet, boolean hasArmor, ZombieKind zombieKind) {
        setZombieName(zombieName);
        setHealthPoint(healthPoint);
        setAttackPower(attackPower);
        setSpeed(speed);
        setShieldHP(shieldHP);
        setLandZombie(isLandZombie);
        setHasDuck(hasDuck);
        setHasHelmet(hasHelmet);
        setHasArmor(hasArmor);
        setZombieKind(zombieKind);
    }

    abstract public void attack(Cell currentCell);

    public void move() {
        Cell cell = this.getCurrentCell();
        Map gameMap = Battle.getRunningBattle().getMap();
        int row = cell.getRow();
        if (cell.getPlant() == null) {
            for (int j = 0; j < MAP_COLUMNS_COUNT; ++j) {
                if (j == cell.getColumn()) {
                    gameMap.getCell(row, j).getZombies().remove(this);
                } else if (j == cell.getColumn() + 1) {
                    gameMap.getCell(row, j).getZombies().add(this);
                    setCurrentCell(gameMap.getCell(row, j));
                    if (this.currentCell.getColumn() == MAP_COLUMNS_COUNT - 1)
                        reachLawnMower(gameMap.getCell(row, j), gameMap);
                    return;
                }
            }
        } else
            this.action();
    }

    public void reachLawnMower(Cell cell, Map gameMap) {
        boolean[] lawnMower = gameMap.getLawnMower();
        if (lawnMower[cell.getRow()] == true) {
            lawnMower[cell.getRow()] = false;
            Battle.lawnMowerActivated(cell, gameMap);
        } else {
            Battle.zombieWins();
        }
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    abstract public <T> void action();

    public boolean hasArmor() {
        return hasArmor;
    }

    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }

    public boolean hasHelmet() {
        return hasHelmet;
    }

    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    public ZombieKind getZombieKind() {
        return zombieKind;
    }

    public void setZombieKind(ZombieKind zombieKind) {
        this.zombieKind = zombieKind;
    }

    public boolean isLandZombie() {
        return isLandZombie;
    }

    public boolean hasDuck() {
        return hasDuck;
    }

    public void setHasDuck(boolean hasDuck) {
        this.hasDuck = hasDuck;
    }

    public void setLandZombie(boolean landZombie) {
        isLandZombie = landZombie;
    }

    public int getShieldHP() {
        return shieldHP;
    }

    public void setShieldHP(int shieldHP) {
        this.shieldHP = shieldHP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public String getZombieName() {
        return zombieName;
    }

    public void setZombieName(String zombieName) {
        this.zombieName = zombieName;
    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public static void setZombies(ArrayList<Zombie> zombies) {
        Zombie.zombies = zombies;
    }
}