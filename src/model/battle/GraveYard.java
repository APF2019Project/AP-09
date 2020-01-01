package model.battle;

import java.util.ArrayList;

public class GraveYard {

    private ArrayList<PlantInGame> deadPlants = new ArrayList<>();
    private ArrayList<ZombieInGame> deadZombies = new ArrayList<>();


    public ArrayList<PlantInGame> getDeadPlants() {
        return deadPlants;
    }

    public ArrayList<ZombieInGame> getDeadZombies() {
        return deadZombies;
    }
}
