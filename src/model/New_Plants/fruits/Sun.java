package model.New_Plants.fruits;

import model.Cell;
import model.New_Plants.warrior.FireRate;
import model.battle.Battle;

import java.util.ArrayList;

public class Sun extends Fruit {

    private int increaseAmount;
    private FireRate fireRate;


    public Sun(int increaseAmount, FireRate fireRate) {
        this.increaseAmount = increaseAmount;
        this.fireRate = fireRate;
    }

    @Override
    public <T> void action(ArrayList<T> inputs) {
        Battle battle = Battle.getRunningBattle();
        battle.getPlants().increaseSun(this.increaseAmount);
    }

    public int getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(int increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    public FireRate getFireRate() {
        return fireRate;
    }
}
