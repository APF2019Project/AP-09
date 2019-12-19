package model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Zombie1> zombies = new ArrayList<Zombie1>();
    private ArrayList<Plant1> plant1s = new ArrayList<Plant1>();

    public ArrayList<Zombie1> getZombie1s() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie1> zombies) {
        this.zombies = zombies;
    }

    public ArrayList<Plant1> getPlant1s() {
        return plant1s;
    }

    public void setPlant1s(ArrayList<Plant1> plant1s) {
        this.plant1s = plant1s;
    }
}
