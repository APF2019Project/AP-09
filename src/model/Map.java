package model;

import constants.Constants;

import java.util.ArrayList;

public class Map {
    private Cell[][] cells = new Cell[Constants.MAP_ROWS_COUNT][Constants.MAP_COLUMNS_COUNT];
    private boolean[] lawnMower = {true , true, true, true, true, true};
    private KindOfMap kindOfMap;
    private static Map currentMap ;



    public Map(KindOfMap kindOfMap){
        this.kindOfMap = kindOfMap ;
        Map.currentMap = this ;
    }

    public static Map getCurrentMap() {
        return currentMap;
    }

    public  boolean isContainZombieInRow(int i){
        for (int j = 0; j < Constants.MAP_COLUMNS_COUNT; j++) {
           if ( currentMap.cells[i][j].getZombies().size() != 0){
               return true ;
           }
        }
        return false ;
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
