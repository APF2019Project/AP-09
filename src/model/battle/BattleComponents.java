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


    public void addBullet(ArrayList<Bullet> bullets) {
        this.fruits.addAll(bullets);
    }

    public void addExplosive(ArrayList<Explosive> explosives){
        this.fruits.addAll(explosives);
    }

    public void addSun(ArrayList<Sun> suns){
        this.fruits.addAll(suns);
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
}
