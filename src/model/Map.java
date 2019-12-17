package model;

import java.util.ArrayList;

public class Map {
    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private int[] lawnMower;
    private KindOfMap kindOfMap;

    public KindOfMap getKindOfMap() {
        return kindOfMap;
    }

    public void setKindOfMap(KindOfMap kindOfMap) {
        this.kindOfMap = kindOfMap;
    }

    public int[] getLawnMower() {
        return lawnMower;
    }

    public void setLawnMower(int[] lawnMower) {
        this.lawnMower = lawnMower;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }
}
