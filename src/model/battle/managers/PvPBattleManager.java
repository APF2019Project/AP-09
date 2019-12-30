package model.battle.managers;

public class PvPBattleManager extends BattleManager {


    @Override
    public void manage() {

        this.getSunGenerator().generateSun();


    }
}
