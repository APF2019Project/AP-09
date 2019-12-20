package model.battle;

import model.New_Plants.Plant;
import model.New_Zombies.Zombie;

import java.util.ArrayList;

public class GraveYard {

  private static   ArrayList<Plant> deadPlants = new ArrayList<>();
  private static  ArrayList<Zombie> deadZombies = new ArrayList<>();


    public static ArrayList<Plant> getDeadPlants() {
        return deadPlants;
    }

    public static ArrayList<Zombie> getDeadZombies() {
        return deadZombies;
    }
}
