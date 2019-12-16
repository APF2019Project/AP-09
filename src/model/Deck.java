package model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private ArrayList<Plant> plants = new ArrayList<Plant>();

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }
}
