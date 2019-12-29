package model.New_Plants.fruits;

import model.Cell;
import model.New_Plants.warrior.FireRate;
import model.battle.Battle;

import java.util.ArrayList;

public class Sun extends Fruit {

    private int increaseAmount;


    public Sun(int increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    @Override
    public <T> void action(ArrayList<T> inputs) {
        Battle battle = Battle.getRunningBattle();
        battle.getPlants().increaseSun(this.increaseAmount);
        this.setDead(true);
    }

    public int getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(int increaseAmount) {
        this.increaseAmount = increaseAmount;
    }
}
