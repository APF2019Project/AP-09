package jsonclass;

import model.Plant;
import model.Zombie;

public class MakePlantAndZombie {
    private MakePlantAndZombie instance = new MakePlantAndZombie();

    private MakePlantAndZombie(){

    }
    public void zombieMaker(){
        new Zombie();//TODO create all 15 zombie and set their variables
        /*
        new Zombie(10 , 13 , 24 , ... );
        ....
        .....
        ......
         */
    }

    public void plantMaker(){
        new Plant();//TODO create all 24 plant and set their variables
        /*
        new Planet(10 , 13 , 24 , ... );
        ....
        .....
        ......
         */
    }

    public MakePlantAndZombie getInstance() {
        return instance;
    }
}
