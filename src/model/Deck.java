package model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private ArrayList<Plant1> plant1s = new ArrayList<Plant1>();

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public ArrayList<Plant1> getPlant1s() {
        return plant1s;
    }

    public void setPlant1s(ArrayList<Plant1> plant1s) {
        this.plant1s = plant1s;
    }
}
