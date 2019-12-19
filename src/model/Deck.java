package model;

import model.New_Plants.Plant;
import model.New_Zombies.Zombie;

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

    public void setPlants(ArrayList<Plant> plant1s) {
        this.plants = plant1s;
    }
}
