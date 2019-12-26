package model.battle;

import constants.Constants;
import model.Cell;
import model.New_Plants.Plant;
import model.New_Plants.fruits.Explosive;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.fruits.Fruit;
import model.New_Plants.fruits.Sun;
import model.New_Zombies.Zombie;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BattleComponents {

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<ZombieInGame> allZombiesInGame = new ArrayList<>();
    private ArrayList<PlantInGame> allPlantsInGame = new ArrayList<>();


    public BattleComponents() {

    }

    public void manage() {
        zombieActions();
        plantsActions();
        fruitsActions();
        checkForDeadPlants();
        checkForDeadZombies();
        checkForDeadFruits();
        checkForLawnMowerActivation();
    }


    private void zombieActions() {
        for (ZombieInGame zombieInGame : this.allZombiesInGame) {
            zombieInGame.action();
        }
    }

    private void plantsActions() {
        for (PlantInGame plantInGame : this.allPlantsInGame) {
            plantInGame.action();
        }
    }


    private void fruitsActions() {
        for (Fruit fruit : this.fruits) {
            fruit.action(null);
        }
    }

    private void checkForDeadPlants() {
        ArrayList<PlantInGame> deadPlants = new ArrayList<>();
        for (PlantInGame plantInGame : this.allPlantsInGame) {
            if (plantInGame.getPlant().isDead()) {
                deadPlants.add(plantInGame);
            }
        }
        this.allPlantsInGame.removeAll(deadPlants);
        Battle.getRunningBattle().getMap().deleteDeadPlants();
        Battle.getRunningBattle().getGraveYard().getDeadPlants().addAll(deadPlants);
    }

    private void checkForDeadZombies() {
        ArrayList<ZombieInGame> deadZombies = new ArrayList<>();
        for (ZombieInGame zombieInGame : this.allZombiesInGame) {
            if (zombieInGame.getZombie().isDead()) {
                deadZombies.add(zombieInGame);
            }
        }
        this.allZombiesInGame.removeAll(deadZombies);
        Battle.getRunningBattle().getMap().deleteDeadZombies();
        Battle.getRunningBattle().getGraveYard().getDeadZombies().addAll(deadZombies);
    }

    private void checkForDeadFruits() {

        ArrayList<Fruit> deadFruits = new ArrayList<>();
        for (Fruit fruit : this.fruits) {
            if (fruit.isDead()) {
                deadFruits.add(fruit);
            }
        }

        this.fruits.removeAll(deadFruits);
        Battle.getRunningBattle().getMap().deleteDeadFruits();
    }




    private void checkForLawnMowerActivation() {

        for (int i = 0; i < Constants.MAP_ROWS_COUNT; i++) {
            Cell cell = Battle.getRunningBattle().getMap().getCell(i, 0);
            if (cell.getZombies().size() >= 1) {
                Battle.getRunningBattle().lawnMowerActivated(cell);
            }
        }
    }

    public ArrayList<ZombieInGame> getAllZombiesInGame() {
        return allZombiesInGame;
    }

    public void addZombieInGame(ZombieInGame zombieInGame) {
        this.allZombiesInGame.add(zombieInGame);
    }

    public void removeZombieFromGame(ZombieInGame zombieInGame) {
        this.allZombiesInGame.remove(zombieInGame);
    }

    public ZombieInGame findZombieInGame(Zombie zombie) {
        for (ZombieInGame z : this.allZombiesInGame) {
            if (z.getZombie().equals(zombie)) {
                return z;
            }
        }
        return null;
    }

    public ArrayList<PlantInGame> getAllPlantsInGame() {
        return allPlantsInGame;
    }

    public void addPlantInGame(PlantInGame plantInGame) {
        this.allPlantsInGame.add(plantInGame);
    }

    public void removePlantFromGame(PlantInGame plantInGame) {
        this.allPlantsInGame.remove(plantInGame);
    }

    public PlantInGame findPlantInGame(Plant plant) {
        for (PlantInGame p : this.allPlantsInGame) {
            if (p.getPlant().equals(plant)) {
                return p;
            }
        }
        return null;
    }

    public void addBullet(ArrayList<Bullet> bullets) {
        this.fruits.addAll(bullets);
    }

    public void addExplosive(ArrayList<Explosive> explosives) {
        this.fruits.addAll(explosives);
    }

    public void addSun(ArrayList<Sun> suns) {
        this.fruits.addAll(suns);
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
}
