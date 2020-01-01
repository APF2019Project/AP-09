package model.battle;

import model.Cell;
import model.Map;
import model.New_Plants.PlantKind;
import model.New_Plants.bomb.Bomb;
import model.New_Plants.deffence.Wall;
import model.New_Plants.fruits.Explosive;
import model.New_Plants.fruits.Bullet;
import model.New_Plants.Plant;
import model.New_Plants.fruits.Fruit;
import model.New_Plants.magnetic.Magnet;
import model.New_Plants.magnetic.Magnetic;
import model.New_Plants.sunFlower.SunFlower;
import model.New_Plants.warrior.Catapult;
import model.New_Plants.warrior.Musketeer;
import model.New_Zombies.Zombie;
import model.New_Zombies.ZombieKind;
import model.New_Zombies.other.HelmetType;
import model.New_Zombies.other.Other;

import java.util.ArrayList;

public class PlantInGame {

    private Plant plant;
    private int readyToFireCounter;
    private Cell currentCell;
    private ArrayList<Bullet> bullets = new ArrayList<>();

    private static ArrayList<PlantInGame> allPlantsInGame;

    public PlantInGame(Plant plant, Cell currentCell) {
        this.plant = plant;
        this.currentCell = currentCell;
        currentCell.setPlantInGame(this);
        Battle.getRunningBattle().getBattleComponents().addPlantInGame(this);
        if (this.plant.getPlantKind() == PlantKind.MUSKETEER || this.plant.getPlantKind() == PlantKind.CATAPULT || this.plant.getPlantKind() == PlantKind.WALL || this.plant.getPlantKind() == PlantKind.MAGNETIC) {
            this.readyToFireCounter = 0;
        } else if (this.plant.getPlantKind() == PlantKind.BOMB) {
            Bomb bomb = (Bomb) this.plant;
            this.readyToFireCounter = bomb.getReadyToFireCounter();
        } else if (this.plant.getPlantKind() == PlantKind.SUNFLOWER) {
            SunFlower sunFlower = (SunFlower) this.plant;
            this.readyToFireCounter = sunFlower.getFireRate().getBulletCount();
        }

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
            case MAGNETIC:
                magneticAction();
                break;
            default:
                break;
        }
    }

    private void magneticAction() {
        if (readyToFireCounter == 0) {
            for (int row = this.currentCell.getRow() - 1; row <= this.currentCell.getRow() + 1; ++row) {
                for (int column = this.currentCell.getColumn() - 1; column <= this.currentCell.getColumn() + 1; ++column) {
                    if (Battle.getRunningBattle().getMap().getCell(row, column).getZombies() != null) {
                        for (ZombieInGame zombieInGame : Battle.getRunningBattle().getMap().getCell(row, column).getZombies()) {
                            Zombie zombie = zombieInGame.getZombie();
                            if (zombie.getZombieKind() == ZombieKind.OTHER) {
                                if (((Other) zombie).getHelmetType() == HelmetType.BUCKETHEAD || zombie.getZombieName().equals("Screen Door Zombie")) {
                                    zombieInGame.getBulletEffect().setStopTime(3);
                                    readyToFireCounter = 3;
                                    if (((Other) zombie).getHelmetType() == HelmetType.BUCKETHEAD && zombie.getHealthPoint() == 2)
                                        zombie.setHealthPoint(zombie.getHealthPoint() - 1);
                                }
                            }
                        }
                    }
                }
            }
        } else
            readyToFireCounter--;
    }

    public void musketeerAction() {
        Musketeer musketeer = (Musketeer) this.plant;
        if (musketeer.getPlantName().equals("Scaredy-shroom")) {
            if (Battle.getRunningBattle().getMap().getCell(this.currentCell.getRow(), this.currentCell.getColumn() - 1).getZombies() != null) {
                return;
            } else if (Battle.getRunningBattle().getMap().getCell(this.currentCell.getRow(), this.currentCell.getColumn() - 2).getZombies() != null) {
                return;
            }
        }
        int flagOfShooting = 0;
        if (readyToFireCounter == 0) {
            for (int i = -musketeer.getRangeOfAttack(); i <= musketeer.getRangeOfAttack(); i++) {
                if ((Battle.getRunningBattle().getMap().isContainZombieInRow(this.getCurrentCell().getRow() + i))) {
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
        ArrayList<ZombieInGame> zombiesInCell = Battle.getRunningBattle().getMap().getCell(this.getCurrentCell().getRow(), this.getCurrentCell().getColumn() + 1).getZombies();
        if (zombiesInCell != null) {
            for (ZombieInGame zombie : zombiesInCell) {
                if (zombie.getZombie().getZombieName().toLowerCase().equals("football zombie")) {
                    return;
                }
            }
            zombiesInCell.get(0).getZombie().decreaseZombieHealthStraight(musketeer.getPhysicalAttack());
            if (zombiesInCell.get(0).getZombie().getHealthPoint() <= 0)
                zombiesInCell.get(0).getZombie().setDead(true);
        }
    }

    public void catapultAction() {
        Catapult catapult = (Catapult) this.plant;
        if ((readyToFireCounter == 0) && (Battle.getRunningBattle().getMap().isContainZombieInRow(this.getCurrentCell().getRow()))) {
            ArrayList<Bullet> bullets = this.plant.operate(Bullet.class);
            readyToFireCounter = catapult.getFireRate().getTurnCount();
        } else if (readyToFireCounter != 0) {
            readyToFireCounter--;
        }
    }

    public void bombAction() {
        if ((readyToFireCounter == 0) && (this.getCurrentCell().getZombies() != null)) {
            ArrayList<Explosive> explosives = this.plant.operate(Explosive.class);
            for (Explosive explosive : explosives) {
                explosive.setPosition(this.currentCell);
            }
            Battle.getRunningBattle().getBattleComponents().addExplosive(explosives);
            this.plant.setDead(true);
        } else if (readyToFireCounter != 0) {
            readyToFireCounter--;
        }
    }

    public void wallAction() {
        Wall wall = (Wall) this.plant;
        if (wall.getPhysicalAttack() != 0) {
            if (this.getCurrentCell().getZombies() != null) {
                this.getCurrentCell().getZombies().get(0).getZombie().decreaseZombieHealthStraight(wall.getPhysicalAttack());
                if (this.getCurrentCell().getZombies().get(0).getZombie().getHealthPoint() <= 0)
                    this.getCurrentCell().getZombies().get(0).getZombie().setDead(true);
            }
        }
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
