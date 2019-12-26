package model.New_Zombies;

import model.Cell;
import model.Map;
import model.New_Plants.fruits.Fruit;
import model.battle.Battle;
import model.battle.ZombieInGame;

import java.util.ArrayList;

import static constants.Constants.MAP_COLUMNS_COUNT;

abstract public class Zombie {
    private static ArrayList<Zombie> zombies = new ArrayList<>();
    private String zombieName;
    private int healthPoint;
    private int attackPower;
    private int speed;
    private int shieldHP;
    private int speedLimited = 0;
    private boolean isLandZombie;
    private boolean hasDuck;
    private boolean hasHelmet;
    private boolean hasArmor;
    private boolean isDead = false;
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
        ZombieInGame zombieInGame = Battle.getRunningBattle().getBattleComponents().findZombieInGame(this);
        Cell cell = this.getCurrentCell();
        Map gameMap = Battle.getRunningBattle().getMap();
        int row = cell.getRow();
        int column = cell.getColumn();
        int speed = this.speed;
        if (speedLimited > 0) {
            speed /= speedLimited;
            setSpeedLimited(0);
        }
        if (cell.getPlant() == null) {
            gameMap.getCell(row, column).getZombies().remove(zombieInGame);
            for (int j = column + 1; j <= column + speed; ++j) {
                if (gameMap.getCell(row, j).getPlant() != null) {
                    gameMap.getCell(row, j).getZombies().add(zombieInGame);
                    zombieInGame.setCurrentCell(gameMap.getCell(row, j));
                    setCurrentCell(gameMap.getCell(row, j));
                    this.action();
                    return;
                } else if (j == MAP_COLUMNS_COUNT - 1) {
                    gameMap.getCell(row, j).getZombies().add(zombieInGame);
                    zombieInGame.setCurrentCell(gameMap.getCell(row, j));
                    setCurrentCell(gameMap.getCell(row, j));
//                    reachLawnMower(currentCell, gameMap
                    return;
                }
                gameMap.getCell(row, j).getZombies().add(zombieInGame);
                zombieInGame.setCurrentCell(gameMap.getCell(row, j));
                setCurrentCell(gameMap.getCell(row, j));
                checkHasFruit(gameMap.getCell(row, j));
                if(j == column + speed)
                    return;
            }
        }
        checkHasFruit(currentCell);
        this.action();
    }

    public void checkHasFruit(Cell cell) {
        if(cell.getFruits() != null){
            for(Fruit f : cell.getFruits()){
                f.action(cell.getZombies());
            }
        }
    }

//    public void reachLawnMower(Cell cell, Map gameMap) {
//        boolean[] lawnMower = gameMap.getLawnMower();
//        if (lawnMower[cell.getRow()]) {
//            lawnMower[cell.getRow()] = false;
//            Battle.getRunningBattle().lawnMowerActivated(cell, gameMap);
//        } else {
//            Battle.zombieWins();
//        }
//    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void decreaseZombieHealthStraight(int attack) {
        if (shieldHP != 0) {
            if (attack >= shieldHP) {
                attack -= shieldHP;
                shieldHP = 0;
                healthPoint -= attack;
            } else {
                shieldHP -= attack;
            }
        } else {
            healthPoint -= attack;
        }
    }

    public void decreaseZombieHealthCurve(int attack) {
        healthPoint -= attack;
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

    public int getSpeedLimited() {
        return speedLimited;
    }

    public void setSpeedLimited(int speedLimited) {
        this.speedLimited = speedLimited;
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