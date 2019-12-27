package model.battle;

import model.Cell;
import model.Map;
import model.New_Plants.fruits.Fruit;
import model.New_Zombies.Zombie;

import java.util.ArrayList;

import static constants.Constants.MAP_COLUMNS_COUNT;

public class ZombieInGame {
    private Zombie zombie;
    private Cell currentCell;
    private static ArrayList<ZombieInGame> allZombiesInGame;

    public ZombieInGame(Zombie zombie, Cell currentCell) {
        setCurrentCell(currentCell);
        currentCell.getZombies().add(this);
        Battle.getRunningBattle().getBattleComponents().addZombieInGame(this);
        setZombie(zombie);
    }

    public static void removeZombieFromGame(ZombieInGame zombieInGame) {
        allZombiesInGame.remove(zombieInGame);
    }
    public static ArrayList<ZombieInGame> getZombiesInGame() {
        return allZombiesInGame;
    }

    public static ZombieInGame findZombieInGame(Zombie zombie){
        for(ZombieInGame z : allZombiesInGame){
            if(z.getZombie().equals(zombie)){
                return z;
            }
        }
        return null;
    }
    public void action() {
        switch (this.getZombie().getZombieKind()) {
            //TODO might need to check something
            case GIGAGARGANTUAR:
                gigagargantuarAction();
                break;
            case BALLOONZOMBIE:
                balloonZombieAction();
                break;
            case BUNGEEZOMBIE:
                bungeeZombieAction();
                break;
            case TRUCKZOMBIE:
                truckZombieAction();
                break;
            case POGOZOMBIE:
                pogoZombieAction();
                break;
            case OTHER:
                otherAction();
                break;
        }
    }
    public void move() {
        Cell cell = this.getCurrentCell();
        Zombie zombie = this.getZombie();
        Map gameMap = Battle.getRunningBattle().getMap();
        int row = cell.getRow();
        int column = cell.getColumn();
        int speed = zombie.getSpeed();
        if(zombie.getStopTime() > 0){
            zombie.setStopTime(zombie.getStopTime() - 1);
            zombie.setSpeedLimited(0);
            return;
        }
        if (zombie.getSpeedLimited() > 0) {
            speed /= zombie.getSpeedLimited();
            zombie.setSpeedLimited(0);
        }
        if (cell.getPlantInGame() == null) {
            gameMap.getCell(row, column).getZombies().remove(this);
            for (int j = column + 1; j <= column + speed; ++j) {
                if (gameMap.getCell(row, j).getPlantInGame() != null) {
                    gameMap.getCell(row, j).getZombies().add(this);
                    this.setCurrentCell(gameMap.getCell(row, j));
                    this.action();
                    return;
                } else if (j == MAP_COLUMNS_COUNT - 1) {
                    gameMap.getCell(row, j).getZombies().add(this);
                    this.setCurrentCell(gameMap.getCell(row, j));
//                    reachLawnMower(currentCell, gameMap
                    return;
                }
                gameMap.getCell(row, j).getZombies().add(this);
                this.setCurrentCell(gameMap.getCell(row, j));
                checkHasFruit(gameMap.getCell(row, j));
                if (j == column + speed){
                    this.action();
                    return;
                }

            }
        }
        checkHasFruit(this.getCurrentCell());
        this.action();
    }
    public void move() {
        Cell cell = this.getCurrentCell();
        Zombie zombie = this.getZombie();
        Map gameMap = Battle.getRunningBattle().getMap();
        int row = cell.getRow();
        int column = cell.getColumn();
        int speed = zombie.getSpeed();
        if(zombie.getStopTime() > 0){
            zombie.setStopTime(zombie.getStopTime() - 1);
            zombie.setSpeedLimited(0);
            return;
        }
        if (zombie.getSpeedLimited() > 0) {
            speed /= zombie.getSpeedLimited();
            zombie.setSpeedLimited(0);
        }
        if (cell.getPlantInGame() == null) {
            gameMap.getCell(row, column).getZombies().remove(this);
            for (int j = column + 1; j <= column + speed; ++j) {
                if (gameMap.getCell(row, j).getPlantInGame() != null) {
                    gameMap.getCell(row, j).getZombies().add(this);
                    this.setCurrentCell(gameMap.getCell(row, j));
                    this.action();
                    return;
                } else if (j == MAP_COLUMNS_COUNT - 1) {
                    gameMap.getCell(row, j).getZombies().add(this);
                   this.setCurrentCell(gameMap.getCell(row, j));
//                    reachLawnMower(currentCell, gameMap
                    return;
                }
                gameMap.getCell(row, j).getZombies().add(this);
                this.setCurrentCell(gameMap.getCell(row, j));
                checkHasFruit(gameMap.getCell(row, j));
                if (j == column + speed){
                    this.action();
                    return;
                }

            }
        }
        checkHasFruit(this.getCurrentCell());
        this.action();
    }
    public void checkHasFruit(Cell cell) {
        if (cell.getFruits() != null) {
            for (Fruit f : cell.getFruits()) {
                f.action(cell.getZombies());
            }
        }
    }
    private void otherAction() {
        this.move();
        //zombie moves first then if the cell has plant it attacks or does it's particular action
        //attacks
    }

    private void pogoZombieAction() {
       this.move();
        //jumps from plants
    }

    private void truckZombieAction() {
        this.move();
        //drives over plants
    }

    private void bungeeZombieAction() {
       this.move();
        //steals a plant
    }

    private void balloonZombieAction() {
       this.move();
        //doesn't get hurt by catapult
    }

    private void gigagargantuarAction() {
       this.move();
        //destroys plant
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }
}
