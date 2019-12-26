package model.battle;

import model.Cell;
import model.New_Zombies.Zombie;

import java.util.ArrayList;

public class ZombieInGame {
    private Zombie zombie;
    private Cell currentCell;
    private static ArrayList<ZombieInGame> allZombiesInGame;

    public ZombieInGame(Zombie zombie, Cell currentCell) {
        setCurrentCell(currentCell);
        setZombie(zombie);
    }

    public static void removeZombieFromGame(ZombieInGame zombieInGame) {
        allZombiesInGame.remove(zombieInGame);
    }

    public void action() {
        switch (this.getZombie().getZombieKind()) {
            //TODO might need to check something
            case GIGAGARGANTUAR:
                gigagargantuarAction();
                break;
            case BALLOONZOMBIE:
                balloonZombieAction();
                break;
            case BUNGEEZOMBIE:
                bungeeZombieAction();
                break;
            case TRUCKZOMBIE:
                truckZombieAction();
                break;
            case POGOZOMBIE:
                pogoZombieAction();
                break;
            case OTHER:
                otherAction();
                break;
        }
    }

    private void otherAction() {
        this.zombie.move();
        //zombie moves first then if the cell has plant it attacks or does it's particular action
        //attacks
    }

    private void pogoZombieAction() {
        this.zombie.move();
        //jumps from plants
    }

    private void truckZombieAction() {
        this.zombie.move();
        //drives over plants
    }

    private void bungeeZombieAction() {
        this.zombie.move();
        //steals a plant
    }

    private void balloonZombieAction() {
        this.zombie.move();
        //doesn't get hurt by catapult
    }

    private void gigagargantuarAction() {
        this.zombie.move();
        //destroys plant
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }
}
