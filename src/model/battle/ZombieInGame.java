package model.battle;

import model.Cell;
import model.New_Zombies.Zombie;

public class ZombieInGame {
    private Zombie zombie;
    private Cell currentCell;

    public ZombieInGame(Zombie zombie, Cell currentCell) {
        setCurrentCell(currentCell);
        setZombie(zombie);
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
        //TODO
    }

    private void pogoZombieAction() {
        //TODO
    }

    private void truckZombieAction() {
        //TODO
    }

    private void bungeeZombieAction() {
        //TODO
    }

    private void balloonZombieAction() {
        //TODO
    }

    private void gigagargantuarAction() {
        //TODO
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
