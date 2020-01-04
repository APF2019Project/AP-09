
package warriorJSON;

import model.New_Plants.bomb.Bomb;
import model.New_Plants.bomb.BombBox;
import model.New_Plants.deffence.Wall;
import model.New_Plants.magnetic.Magnetic;
import model.New_Plants.sunFlower.SunFlower;
import model.New_Plants.warrior.Catapult;
import model.New_Plants.warrior.FireRate;
import model.New_Plants.warrior.Musketeer;
import model.New_Zombies.Zombie;
import model.New_Zombies.other.HelmetType;
import model.New_Zombies.other.Other;
import model.New_Zombies.uniqueZombie.*;

public class MakePlantAndZombie {
    private static MakePlantAndZombie instance = new MakePlantAndZombie();

    private MakePlantAndZombie() {
    }

    public void make() {
        zombieMaker();
        plantMaker();
    }

    private void zombieMaker() {

        new Other("Zombie", 2, 1, 2,0, true, false, false, false, HelmetType.NONE); //Zombie
        new Other("FootballZombie", 4, 1, 3,0, true, false, false, true, HelmetType.NONE); //Football Zombie
        new Other("BucketheadZombie", 3, 1, 2,0,true, false, true, false, HelmetType.BUCKETHEAD); //BucketHead Zombie
        new Other("ConeheadZombie", 3, 1,2, 0, true, false, true, false, HelmetType.CONEHEAD); //ConeHead Zombie
        new TruckZombie("Zomboni", 3, 0, 2, 0, true, false, false, false, true);//Zomboni
        new TruckZombie("CatapultZombie", 3, 0, 2, 0, true, false, false, false, false);//Catapult Zombie
        new BungeeZombie("BungeeZombie", 3,0,0, 0, true, false, false, false);//Bungee Zombie
        new BalloonZombie("BalloonZombie", 3, 1, 2, 0,true, false, false, false);//Balloon Zombie
        new Other("NewspaperZombie", 2, 1,2, 2, true, false, false, false, HelmetType.NONE);//Newspaper Zombie
        new Other("TargetZombie", 3, 1,2, 3, true, false, false, false, HelmetType.NONE);//Target Zombie
        new Other("ScreenDoorZombie", 2, 1,2, 4, true, false, false, false, HelmetType.NONE);//Screen Door Zombie
        new Gigagargantuar("Giga-gargantuar", 3, 0, 2, 0, true, false, false, false);//Giga gargantuar
        new PogoZombie("PogoZombie", 2, 0, 2, 0, true, false, false, false);//Pogo Zombie
        new Other("SnorkelZombie", 2, 1,2, 0, false, false, false, false, HelmetType.NONE);//Snorkel Zombie
        new Other("DolphinRiderZombie", 2, 1,2, 2, false, false, false, false, HelmetType.NONE);//Dolphin Rider Zombie

    }

    private void plantMaker() {

        new Musketeer("Peashooter", 2, 1, 2, 2, 0, new FireRate(1, 2),0,0);//Peashooter
        new Musketeer("SnowPea", 3, 1, 3, 3, 2, new FireRate(1, 3),0,0);//Snow Pea
        new Catapult("Cabbage-pult", 2, 2, 3, 2, 0, new FireRate(1, 2),0);//Cabbage-pult
        new Musketeer("Repeater", 4, 1, 4, 3, 0, new FireRate(2, 3),0,0);//Repeater
        new Musketeer("Threepeater", 5, 1, 4, 4, 0, new FireRate(1, 4),1, 0);//Threepeater
        new Musketeer("Cactus", 5, 1, 4, 5, 0, new FireRate(1, 2),0,1);//Cactus
        new Musketeer("Gatling Pea", 3, 1, 4, 5, 0, new FireRate(4, 5),0,0);//Gatling Pea
        new Musketeer("Scaredy-shroom", 1, 1, 2, 1, 0, new FireRate(1, 2),0,0);//Scaredy-shroom
        new Catapult("Kernel-pult", 2, 0, 3, 3, 0, new FireRate(1, 4),2);//Kernel-pult
      //  new Musketeer("Split Pea", 3, 1, 4, 4, 0, new FireRate());//Split Pea
        new Wall("Explode-o-nut", 3, 1, 5, 4,1);//Explode-o-nut
        new Catapult("Melon-pult", 3, 3, 3, 3, 0, new FireRate(1, 4),0);//Melon-pult
      //  new Other("Lily Pad", 1, 0, 1, 0);//Lily Pad
        new Catapult("WinterMelon", 3, 3, 5, 4, 2, new FireRate(1, 4),0);//Winter Melon
        new Wall("Wall-nut", 4, 0, 4, 2,0);//Wall-nut
      //  new Other("Tangle Kelp", 0, 0, 3, 3);//Tangle Kelp
        new Wall("Tall-nut", 6, 0, 6, 4,0);//Tall-nut
       // new Musketeer("Cattail", 3, 1, 5, 5, 0, new FireRate());//Cattail
        new Bomb("PotatoMine", 1, 0, 3, 2, new BombBox(1, 1));//Potato Mine
        new Bomb("CherryBomb", 0, 0, 4, 2, new BombBox(9, 9));//Cherry Bomb
        new Magnetic("Magnet-shroom", 2, 0, 4, 4);//Magnet-shroom
        new SunFlower("Sunflower", 2, 0, 2, 1, new FireRate(1, 2));//Sunflower
        new SunFlower("TwinSunflower", 2, 0, 5, 3, new FireRate(2, 2));//Twin Sunflower
        new Bomb("Jalapeno", 0, 0, 5, 4, new BombBox(20, 1));//Jalapeno

    }

    public static MakePlantAndZombie getInstance() {
        return instance;
    }
}