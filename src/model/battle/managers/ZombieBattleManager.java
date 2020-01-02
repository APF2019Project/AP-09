package model.battle.managers;

import model.Cell;
import model.battle.Battle;
import model.card.CardOfZombie;

public class ZombieBattleManager extends BattleManager {


    public ZombieBattleManager() {
        this.setPlantsInMap();
    }


    @Override
    public void manage() {
        Battle.getRunningBattle().getBattleComponents().manage();
        this.checkForPlantsWin();
        this.checkForZombiesWin();
        Battle.getRunningBattle().incrementTurn();
    }

    private void setPlantsInMap() {

    }

    private void insertZombie(int count) {


    }

    private boolean insertZombieValidation(int count) {
        int coinsNeeded = count * 10 * (((CardOfZombie) Battle.getRunningBattle().getSelectedCard()).getZombie().getHealthPoint());
        if (Battle.getRunningBattle().getZombies().getSun() >= coinsNeeded) {
            if (this.getNumberOfZombiesInACellRow(Battle.getRunningBattle().getSelectedCell()) + count <= 2) {
                for (int i = 0; i < count; i++) {
                    //TODO should create zombieInGames for selected cell
                }
            } else {
                // TODO should print a error that this row can maximum have 2 zombies
            }
        } else {
            // TODO should print a error that player doesn't have enough coins
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
