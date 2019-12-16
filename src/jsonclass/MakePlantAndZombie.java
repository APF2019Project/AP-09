package jsonclass;

import model.HelmetType;
import model.Plant;
import model.TruckType;
import model.Zombie;
import model.ZombieType;

public class MakePlantAndZombie {
    private static MakePlantAndZombie instance = new MakePlantAndZombie();

    private MakePlantAndZombie() {
    }

    public void make() {
        zombieMaker();
        plantMaker();
    }

    private void zombieMaker() {
        new Zombie(2, 2, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, false); //Zombie
        new Zombie(3, 4, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, true, false); //Football Zombie
        new Zombie(2, 3, 1, 0, ZombieType.LAND, HelmetType.BUCKETHEAD, TruckType.NONE, true, false, false, false, false, false, false, false, false); //BucketHead Zombie
        new Zombie(2, 3, 1, 0, ZombieType.LAND, HelmetType.CONEHEAD, TruckType.NONE, true, false, false, false, false, false, false, false, false); //ConeHead Zombie
        new Zombie(2, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.STRONG, false, true, false, false, false, false, false, false, false);//Zomboni
        new Zombie(2, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.WEAK, false, true, false, false, false, false, false, false, false);//Catapult Zombie
        new Zombie(0, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, true, false, false, false, false, false, false);//Bungee Zombie
        new Zombie(2, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, true, false, false, false, false, false);//Balloon Zombie
        new Zombie(2, 2, 1, 2, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Newspaper Zombie
        new Zombie(2, 3, 1, 3, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Target Zombie
        new Zombie(2, 2, 1, 4, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Screen Door Zombie
        new Zombie(1, 6, 0, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, true, false, false, false, false);//Giga gargantuar
        new Zombie(2, 2, 0, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, true, false, false, false);//Pogo Zombie
        new Zombie(2, 2, 1, 0, ZombieType.WATER, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, false);//Snorkel Zombie
        new Zombie(2, 2, 1, 2, ZombieType.WATER, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Dolphin Rider Zombie

    }


    private void plantMaker() {
        new Plant();//TODO create all 24 plant and set their variables
        /*
        new Planet(10 , 13 , 24 , ... );
        ....
        .....
        ......
         */
    }

    public static MakePlantAndZombie getInstance() {
        return instance;
    }
}
