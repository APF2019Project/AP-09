package model.battle.managers;

import model.constants.Constants;
import model.Cell;
import model.battle.Battle;
import model.battle.SunGenerator;

abstract public class BattleManager {

    private SunGenerator sunGenerator = new SunGenerator();


    abstract public void manage();

    abstract public void insertCard();

    public SunGenerator getSunGenerator() {
        return sunGenerator;
    }

    void checkForZombiesWin() {

        for (int i = 0; i < Constants.MAP_ROWS_COUNT; i++) {
            Cell cell = Battle.getRunningBattle().getMap().getCell(i, 0);
            if (cell.getZombies().size() >= 1 && !Battle.getRunningBattle().getMap().getLawnMower()[cell.getRow()]) {
                Battle.getRunningBattle().setWinnerPlayer(Battle.getRunningBattle().getZombies());
                Battle.getRunningBattle().setEndGame(true);
                Battle.getRunningBattle().increaseZombieMoney(Battle.getRunningBattle().getZombies().getAccount());
            }
        }
    }

    void checkForPlantsWin() {
        if (Battle.getRunningBattle().getWavesCount() == 0) {
            Battle.getRunningBattle().setWinnerPlayer(Battle.getRunningBattle().getPlants());
            Battle.getRunningBattle().setEndGame(true);
        }
    }
}
