package model.battle.managers;

public class WaterBattleManager extends BattleManager {

    @Override
    public void manage() {

        this.getSunGenerator().generateSun();


    }

}
