package model.battle;

import model.Cell;
import model.Map;
import model.New_Plants.bomb.Bomb;
import model.New_Plants.fruits.Explosive;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.Plant;
import model.New_Plants.fruits.Fruit;
import model.New_Plants.warrior.Musketeer;

import java.util.ArrayList;

public class PlantInGame {

    private Plant plant;
    private  int readyToFireCounter ;
    private Cell currentCell;
    private ArrayList<Bullet> bullets = new ArrayList<>();

    private static ArrayList<PlantInGame> allPlantsInGame ;

    public PlantInGame(Plant plant, Cell currentCell, int readyToFireCounter) {  //todo baraye musketeer o catapult 0 byd bashe baraye bomb o sun byd readtofire khodeshooon bashe
        this.plant = plant;
        this.currentCell = currentCell;
        this.readyToFireCounter = readyToFireCounter ;
    }

    public static ArrayList<PlantInGame> getAllPlantsInGame() {
        return allPlantsInGame;
    }

    public void action() {
        switch (this.plant.getPlantKind()) {
            case MUSKETEER:
                musketeerAction();
                break;
            case CATAPULT:
                catapultAction();
                break;
            case BOMB:
                bombAction();
                break;
            case WALL:
                wallAction();
                break;
            case OTHER:
                otherAction();
                break;
            default:
                break;
        }
    }

    public void musketeerAction() {
        Musketeer musketeer = (Musketeer) this.plant;
        int flagOfShooting = 0;
        if (readyToFireCounter == 0) {
            for (int i = -musketeer.getRangeOfAttack(); i <= musketeer.getRangeOfAttack(); i++) {
                if ((Map.getCurrentMap().isContainZombieInRow(this.getCurrentCell().getRow() + i))) {
                    flagOfShooting = 1;
                    ArrayList<Bullet> bullets = this.plant.operate(Bullet.class);
                    for (Bullet bullet : bullets) {
                        bullet.setPosition(this.currentCell);
                        bullet.setRadius(i);
                        this.getCurrentCell().getFruits().add(bullet);
                    }
                    Battle.getRunningBattle().getBattleComponents().addBullet(bullets);
                }
            }
            if (flagOfShooting == 1) {
                this.readyToFireCounter = musketeer.getFireRate().getTurnCount();
            }
        } else
            this.readyToFireCounter--;
    }

    public void catapultAction() {
        //TODO
        ArrayList<Bullet> bullets = this.plant.operate(Bullet.class);
    }

    public void bombAction() {
        if ((readyToFireCounter==0) && (this.getCurrentCell().getZombies() != null)) {
            ArrayList<Explosive> explosives = this.plant.operate(Explosive.class);
            for (Explosive explosive : explosives) {
                explosive.setPosition(this.currentCell);
            }
            Battle.getRunningBattle().getBattleComponents().addExplosive(explosives);
            this.plant.setDead(true);
        }else if (readyToFireCounter != 0){
            readyToFireCounter -- ;
        }
        }

    public void wallAction() {
        //TODO
    }

    public void otherAction() {
        //TODO
    }



    public Plant getPlant() {
        return plant;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public int getReadyToFireCounter() {
        return readyToFireCounter;
    }

    public void setReadyToFireCounter(int readyToFireCounter) {
        this.readyToFireCounter = readyToFireCounter;
    }
}
