package model.battle.managers;

import com.rits.cloning.Cloner;
import model.New_Plants.Plant;
import model.battle.Battle;
import model.battle.PlantInGame;
import model.card.CardOfPlant;

public class RailBattleManager extends BattleManager {

    private RailGenerator railGenerator = new RailGenerator();
    private RailModeZombieGenerator railModeZombieGenerator = new RailModeZombieGenerator();

    @Override
    public void manage() {
        this.railGenerator.generatePlant();
        this.railModeZombieGenerator.generateZombie();
        Battle.getRunningBattle().getBattleComponents().manage();
        this.checkForPlantsWin();
        this.checkForZombiesWin();
        Battle.getRunningBattle().incrementTurn();
    }

    public void insertPlantCard() {
        if (Battle.getRunningBattle().checkSelectedCellIsValidForInsertPlant(Battle.getRunningBattle().getSelectedCell())) {
            Cloner cloner = new Cloner();
            Plant newPlantInGame = cloner.deepClone(((CardOfPlant) Battle.getRunningBattle().getSelectedCard()).getPlant());
            new PlantInGame(newPlantInGame, Battle.getRunningBattle().getSelectedCell());
            this.railGenerator.removeCard((CardOfPlant) Battle.getRunningBattle().getSelectedCard());
        }
    }


    public RailGenerator getRailGenerator() {
        return railGenerator;
    }
}
