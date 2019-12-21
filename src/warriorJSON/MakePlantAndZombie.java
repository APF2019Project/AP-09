
package warriorJSON;

import model.*;

public class MakePlantAndZombie {
    private static MakePlantAndZombie instance = new MakePlantAndZombie();

    private MakePlantAndZombie() {
    }

    public void make() {
        zombieMaker();
        plantMaker();
    }

    private void zombieMaker() {
        /*
        new Other("Zombie", 2, 1, 2,0, true, false, false, false, HelmetType.NONE); //Zombie
        new Other("Football Zombie", 4, 1, 3,0, true, false, false, true, HelmetType.NONE); //Football Zombie
        new Other("Buckethead Zombie", 3, 1, 2,0,true, false, true, false, HelmetType.BUCKETHEAD); //BucketHead Zombie
        new Zombie("Conehead Zombie", 3, 1,2, 0, true, false, true, false, HelmetType.CONEHEAD); //ConeHead Zombie
        new TruckZombie("Zomboni", 3, 0, 2, 0, true, false, false, false, true);//Zomboni
        new TruckZombie("Catapult Zombie", 3, 0, 2, 0, true, false, false, false, false);//Catapult Zombie
        new BungeeZombie("Bungee Zombie", 3,0,0, 0, true, false, false, false);//Bungee Zombie
        new BalloonZombie("Balloon Zombie", 3, 1, 2, 0,true, false, false, false);//Balloon Zombie
        new Other("Newspaper Zombie", 2, 1,2, 2, true, false, false, false, HelmetType.NONE);//Newspaper Zombie
        new Other("Target Zombie", 3, 1,2, 3, true, false, false, false, HelmetType.NONE);//Target Zombie
        new Other("Screen Door Zombie", 2, 1,2, 4, true, false, false, false, HelmetType.NONE);//Screen Door Zombie
        new Gigagargantuar("Giga-gargantuar", 3, 0, 2, 0, true, false, false, false);//Giga gargantuar
        new PogoZombie("Pogo Zombie", 2, 0, 2, 0, true, false, false, false);//Pogo Zombie
        new Other("Snorkel Zombie", 2, 1,2, 0, false, false, false, false, HelmetType.NONE);//Snorkel Zombie
        new Other("Dolphin Rider Zombie", 2, 1,2, 2, false, false, false, false, HelmetType.NONE);//Dolphin Rider Zombie
        */
    }

    private void plantMaker() {
        /*
        new Musketeer("Peashooter", 2, 1, 2, 2, 0, new FireRate(1, 2));//Peashooter
        new Musketeer("Snow Pea", 3, 1, 3, 3, 2, new FireRate(1, 3));//Snow Pea
        new Catapult("Cabbage-pult", 2, 2, 3, 2, 0, new FireRate(1, 2));//Cabbage-pult
        new Musketeer("Repeater", 4, 1, 4, 3, 0, new FireRate(2, 3));//Repeater
        new Musketeer("Threepeater", 5, 1, 4, 4, 0, new FireRate(1, 4));//Threepeater
        new Musketeer("Cactus", 5, 1, 4, 5, 0, new FireRate(1, 2));//Cactus
        new Musketeer("Gatling Pea", 3, 1, 4, 5, 0, new FireRate(4, 5));//Gatling Pea
        new Musketeer("Scaredy-shroom", 1, 1, 2, 1, 0, new FireRate(1, 2));//Scaredy-shroom
        new Catapult("Kernel-pult", 2, 0, 3, 3, 0, new FireRate(1, 4));//Kernel-pult
        new Musketeer("Split Pea", 3, 1, 4, 4, 0, new FireRate());//Split Pea
        new Wall("Explode-o-nut", 3, 1, 5, 4);//Explode-o-nut
        new Catapult("Melon-pult", 3, 3, 3, 3, 0, new FireRate(1, 4));//Melon-pult
        new Other("Lily Pad", 1, 0, 1, 0);//Lily Pad
        new Catapult("Winter Melon", 3, 3, 5, 4, 2, new FireRate(1, 4));//Winter Melon
        new Wall("Wall-nut", 4, 0, 4, 2);//Wall-nut
        new Other("Tangle Kelp", 0, 0, 3, 3);//Tangle Kelp
        new Wall("Tall-nut", 6, 0, 6, 4);//Tall-nut
        new Musketeer("Cattail", 3, 1, 5, 5, 0, new FireRate());//Cattail
        new Bomb("Potato Mine", 1, 0, 3, 2, new BombBox(1, 1));//Potato Mine
        new Bomb("Cherry Bomb", 0, 0, 4, 2, new BombBox(9, 9));//Cherry Bomb
        new Magnetic("Magnet-shroom", 2, 0, 4, 4);//Magnet-shroom
        new SunFlower("Sunflower", 2, 0, 2, 1, new FireRate(1, 2));//Sunflower
        new SunFlower("Twin Sunflower", 2, 0, 5, 3, new FireRate(2, 2));//Twin Sunflower
        new Bomb("Jalapeno", 0, 0, 5, 4, new BombBox(20, 1));//Jalapeno
        */
    }

    public static MakePlantAndZombie getInstance() {
        return instance;
         */
    }
}