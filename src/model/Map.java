package model;

import model.constants.Constants;
import model.New_Plants.fruits.Fruit;
import model.battle.ZombieInGame;

import java.util.ArrayList;

public class Map {
    private Cell[][] cells = new Cell[Constants.MAP_ROWS_COUNT][Constants.MAP_COLUMNS_COUNT];
    private boolean[] lawnMower = {true, true, true, true, true, true};
    private KindOfMap kindOfMap;
    private static Map currentMap;


    public Map(KindOfMap kindOfMap) {
        this.kindOfMap = kindOfMap;
        Map.currentMap = this;
    }

    public static Map getCurrentMap() {
        return currentMap;
    }

    public boolean isContainZombieInRow(int i) {
        for (int j = 0; j < Constants.MAP_COLUMNS_COUNT; j++) {
            if (currentMap.cells[i][j].getZombies().size() != 0) {
                return true;
            }
        }
        return false;
    }

    public void deleteDeadPlants() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                if (this.cells[i][j].getPlantInGame().getPlant().isDead()) {
                    this.cells[i][j].setPlantInGame(null);
                }
            }
        }
    }

    public void deleteDeadZombies() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                ArrayList<ZombieInGame> deadZombies = new ArrayList<>();
                for (int k = 0; k < this.cells[i][j].getZombies().size(); k++) {
                    if (this.cells[i][j].getZombies().get(k).getZombie().isDead())
                        deadZombies.add(this.cells[i][j].getZombies().get(k));
                }
                this.cells[i][j].getZombies().removeAll(deadZombies);
            }
        }
    }

    public void deleteDeadFruits() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                ArrayList<Fruit> deadFruits = new ArrayList<>();
                for (int k = 0; k < this.cells[i][j].getFruits().size(); k++) {
                    if (this.cells[i][j].getFruits().get(k).isDead())
                        deadFruits.add(this.cells[i][j].getFruits().get(k));
                }
                this.cells[i][j].getFruits().removeAll(deadFruits);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public KindOfMap getKindOfMap() {
        return kindOfMap;
    }

    public void setKindOfMap(KindOfMap kindOfMap) {
        this.kindOfMap = kindOfMap;
    }

    public boolean[] getLawnMower() {
        return lawnMower;
    }

    public void setLawnMower(boolean[] lawnMower) {
        this.lawnMower = lawnMower;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
