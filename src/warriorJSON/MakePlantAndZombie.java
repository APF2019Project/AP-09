
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
        new Zombie1("Zombie", 2, 2, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, false); //Zombie
        new Zombie1("Football Zombie", 3, 4, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, true, false); //Football Zombie
        new Zombie1("Buckethead Zombie", 2, 3, 1, 0, ZombieType.LAND, HelmetType.BUCKETHEAD, TruckType.NONE, true, false, false, false, false, false, false, false, false); //BucketHead Zombie
        new Zombie1("Conehead Zombie", 2, 3, 1, 0, ZombieType.LAND, HelmetType.CONEHEAD, TruckType.NONE, true, false, false, false, false, false, false, false, false); //ConeHead Zombie
        new Zombie1("Zomboni", 2, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.STRONG, false, true, false, false, false, false, false, false, false);//Zomboni
        new Zombie1("Catapult Zombie", 2, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.WEAK, false, true, false, false, false, false, false, false, false);//Catapult Zombie
        new Zombie1("Bungee Zombie", 0, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, true, false, false, false, false, false, false);//Bungee Zombie
        new Zombie1("Balloon Zombie", 2, 3, 1, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, true, false, false, false, false, false);//Balloon Zombie
        new Zombie1("Newspaper Zombie", 2, 2, 1, 2, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Newspaper Zombie
        new Zombie1("Target Zombie", 2, 3, 1, 3, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Target Zombie
        new Zombie1("Screen Door Zombie", 2, 2, 1, 4, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Screen Door Zombie
        new Zombie1("Giga-gargantuar", 1, 6, 0, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, true, false, false, false, false);//Giga gargantuar
        new Zombie1("Pogo Zombie", 2, 2, 0, 0, ZombieType.LAND, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, true, false, false, false);//Pogo Zombie
        new Zombie1("Snorkel Zombie", 2, 2, 1, 0, ZombieType.WATER, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, false);//Snorkel Zombie
        new Zombie1("Dolphin Rider Zombie", 2, 2, 1, 2, ZombieType.WATER, HelmetType.NONE, TruckType.NONE, false, false, false, false, false, false, false, false, true);//Dolphin Rider Zombie
    }

    private void plantMaker() {
        new Plant1("Peashooter", 2, 2, 1, 2, 2, PlantType.LAND, BulletType.PEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Peashooter
        new Plant1("Snow Pea", 3, 3, 1, 3, 3, PlantType.LAND, BulletType.PEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, true, false, false, false, false, false, false, false, false);//Snow Pea
        new Plant1("Cabbage-pult", 2, 2, 2, 3, 2, PlantType.LAND, BulletType.PROJECTILE, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Cabbage-pult
        new Plant1("Repeater", 3, 4, 1, 4, 3, PlantType.LAND, BulletType.REPEATER, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Repeater
        new Plant1("Threepeater", 4, 5, 1, 4, 4, PlantType.LAND, BulletType.THREEPEATER, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Threepeater
        new Plant1("Cactus", 2, 5, 1, 4, 5, PlantType.LAND, BulletType.PEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, true, false, false, false, false, false, false);//Cactus
        new Plant1("Gatling Pea", 5, 3, 1, 4, 5, PlantType.LAND, BulletType.GATLINGPEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Gatling Pea
        new Plant1("Scaredy-shroom", 2, 1, 1, 2, 1, PlantType.LAND, BulletType.PEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, true, false, false, false, false, false);//Scaredy-shroom
        new Plant1("Kernel-pult", 4, 2, 0, 3, 3, PlantType.LAND, BulletType.PROJECTILE, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, true);//Kernel-pult
        new Plant1("Split Pea", 0, 3, 1, 4, 4, PlantType.LAND, BulletType.SPLITPEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Split Pea
        new Plant1("Explode-o-nut", 0, 3, 1, 5, 4, PlantType.LAND, BulletType.NONE, BombType.NONE, NutType.EXPLODEONUT, SunflowerType.NONE, false, false, true, false, false, false, false, false, false, false, false, false, false);//Explode-o-nut
        new Plant1("Melon-pult", 4, 3, 3, 3, 3, PlantType.LAND, BulletType.PROJECTILE, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, false, false, false);//Melon-pult
        new Plant1("Lily Pad", 0, 1, 0, 1, 0, PlantType.WATER, BulletType.NONE, BombType.NONE, NutType.NONE, SunflowerType.NONE, false, false, false, false, false, false, false, false, true, false, false, false, false);//Lily Pad
        new Plant1("Winter Melon", 4, 3, 3, 5, 4, PlantType.LAND, BulletType.PROJECTILE, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, true, false, false, false, false, false, false, false, false);//Winter Melon
        new Plant1("Wall-nut", 0, 4, 0, 4, 2, PlantType.LAND, BulletType.NONE, BombType.NONE, NutType.WALLNUT, SunflowerType.NONE, false, false, true, false, false, false, false, false, false, false, false, false, false);//Wall-nut
        new Plant1("Tangle Kelp", 0, 1, 0, 3, 3, PlantType.WATER, BulletType.NONE, BombType.NONE, NutType.NONE, SunflowerType.NONE, false, false, false, false, false, false, false, false, false, true, false, false, false);//Tangle Kelp
        new Plant1("Tall-nut", 0, 6, 0, 6, 4, PlantType.LAND, BulletType.NONE, BombType.NONE, NutType.TALLNUT, SunflowerType.NONE, false, false, true, false, false, false, false, false, false, false, false, false, false);//Tall-nut
        //new Plant("Cattail", 0, 3, 1, 5, 5, PlantType.LAND, BulletType.PEA, BombType.NONE, NutType.NONE, SunflowerType.NONE, true, false, false, false, false, false, false, false, false, false, true, false, false);//Cattail
        new Plant1("Potato Mine", 1, 1, 0, 3, 2, PlantType.LAND, BulletType.NONE, BombType.POTATO, NutType.NONE, SunflowerType.NONE, false, true, false, false, false, false, false, false, false, false, false, false, false);//Potato Mine
        new Plant1("Cherry Bomb", 0, 1, 0, 4, 2, PlantType.LAND, BulletType.NONE, BombType.CHERRY, NutType.NONE, SunflowerType.NONE, false, true, false, false, false, false, false, false, false, false, false, false, false);//Cherry Bomb
        new Plant1("Magnet-shroom", 3, 2, 0, 4, 4, PlantType.LAND, BulletType.NONE, BombType.NONE, NutType.NONE, SunflowerType.NONE, false, false, false, false, false, false, false, false, false, false, false, true, false);//Magnet-shroom
        new Plant1("Sunflower", 2, 2, 0, 2, 1, PlantType.LAND, BulletType.NONE, BombType.NONE, NutType.NONE, SunflowerType.SINGLE, false, false, false, true, false, false, false, false, false, false, false, false, false);//Sunflower
        new Plant1("Twin Sunflower", 2, 2, 0, 5, 3, PlantType.LAND, BulletType.NONE, BombType.NONE, NutType.NONE, SunflowerType.TWIN, false, false, false, true, false, false, false, false, false, false, false, false, false);//Twin Sunflower
        new Plant1("Jalapeno", 0, 1, 0, 5, 4, PlantType.LAND, BulletType.NONE, BombType.JALAPENO, NutType.NONE, SunflowerType.NONE, false, true, false, false, false, false, false, false, false, false, false, false, false);//Jalapeno


    }

    public static MakePlantAndZombie getInstance() {
        return instance;
    }
}