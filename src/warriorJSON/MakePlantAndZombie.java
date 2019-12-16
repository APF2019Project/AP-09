package warriorJSON;

import model.Plant;
import model.Zombie;

import static model.ZombieType.LAND;

public class MakePlantAndZombie {
    private static MakePlantAndZombie instance = new MakePlantAndZombie();

    private MakePlantAndZombie(){
    }

    public void make(){
        zombieMaker();
        plantMaker();
    }
    private void zombieMaker(){
        new Zombie();//TODO create all 15 zombie and set their variables
        /*
        new Zombie(10 , 13 , 24 , ... );
        ....
        .....
        ......
         */
    }

    private void plantMaker(){
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
