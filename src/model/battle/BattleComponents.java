package model.battle;

import model.New_Plants.fruits.Explosive;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.fruits.Fruit;
import model.New_Plants.fruits.Sun;

import java.util.ArrayList;

public class BattleComponents {


    private ArrayList<Fruit> fruits = new ArrayList<>();


    public BattleComponents() {

    }


    public void addFruit(ArrayList<Fruit> fruits) {
        this.fruits.addAll(fruits);
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
}
