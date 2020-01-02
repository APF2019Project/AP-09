package model.battle.managers;

import model.Cell;
import model.New_Plants.Plant;
import model.New_Zombies.Zombie;
import model.battle.Battle;
import model.battle.PlantInGame;
import model.battle.ZombieInGame;
import model.card.CardOfZombie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ZombieBattleManager extends BattleManager {

    private final int plantsCount = 18;
    private final HashMap<String, Integer> plantsAndTheirCounts = new HashMap<>();

    public ZombieBattleManager() {
        this.initializePlantsAndTheirCountNeeded();
        this.setPlantsInMap();
    }


    @Override
    public void manage() {
        Battle.getRunningBattle().getBattleComponents().manage();
        this.checkForPlantsWin();
        this.checkForZombiesWin();
        Battle.getRunningBattle().incrementTurn();
    }

    private void initializePlantsAndTheirCountNeeded() {
        this.plantsAndTheirCounts.put("Explode-o-nut", 3);
        this.plantsAndTheirCounts.put("Scaredy-shroom", 6);
        this.plantsAndTheirCounts.put("SnowPea", 2);
        this.plantsAndTheirCounts.put("Cabbage-pult", 2);
        this.plantsAndTheirCounts.put("Threepeater", 1);
        this.plantsAndTheirCounts.put("GatlingPea", 1);
        this.plantsAndTheirCounts.put("PotatoMine", 3);
    }

    private void setPlantsInMap() {
        ArrayList<Cell> randomCells = this.getRandomCells(this.plantsCount);
        for (Map.Entry element : this.plantsAndTheirCounts.entrySet()) {
            for (int i = 0; i < (int) element.getValue(); i++) {
                Plant plant = Plant.getPlant((String) element.getKey());
                new PlantInGame(plant, randomCells.get(0));
                randomCells.remove(0);
            }
        }
    }

    private ArrayList<Cell> getRandomCells(int randomCellsCount) {
        ArrayList<Cell> randomCells = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < randomCellsCount; i++) {
            int randomRow = random.nextInt(6);
            int randomColumn = 2 * random.nextInt(9) + 1;
            Cell cell = Battle.getRunningBattle().getMap().getCell(randomRow, randomColumn);
            while (randomCells.contains(cell)) {
                randomRow = random.nextInt(6);
                randomColumn = 2 * random.nextInt(9) + 1;
                cell = Battle.getRunningBattle().getMap().getCell(randomRow, randomColumn);
            }
            randomCells.add(cell);
        }
        return randomCells;
    }

    private void insertZombie(int count) {
        int coinsNeeded = count * 10 * (((CardOfZombie) Battle.getRunningBattle().getSelectedCard()).getZombie().getHealthPoint());
        if (Battle.getRunningBattle().getZombies().getSun() >= coinsNeeded) {
            if (this.getNumberOfZombiesInACellRow(Battle.getRunningBattle().getSelectedCell()) + count <= 2) {
                for (int i = 0; i < count; i++) {
                    Zombie zombie = ((CardOfZombie) Battle.getRunningBattle().getSelectedCard()).getZombie();
                    new ZombieInGame(zombie, Battle.getRunningBattle().getSelectedCell());
                }
            } else {
                // TODO should print a error that this row can maximum have 2 zombies
                System.out.println("A Row can have maximum of 2 zombies in a wave");
            }
        } else {
            // TODO should print a error that player doesn't have enough coins
            System.out.println("You Don't have enough Coins");
        }

    }

    private int getNumberOfZombiesInACellRow(Cell cell) {
        int counter = 0;
        for (int i = 0; i < Battle.getRunningBattle().getMap().getCells()[cell.getRow()].length; i++) {
            counter += Battle.getRunningBattle().getMap().getCells()[cell.getRow()][i].getZombies().size();
        }
        return counter;
    }


}
