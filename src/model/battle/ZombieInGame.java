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
        //jump from plants
        //HOW MANY TIME??????
    }

    private void truckZombieAction() {
        //TODO
        //plant should die instantly
        //if it has strong truck it turns into normal zombie
    }

    private void bungeeZombieAction() {
        //TODO
       //goes to a cell randomly and steals plant
    }

    private void balloonZombieAction() {
        //TODO
        //doesn't get hurt by peas
    }

    private void gigagargantuarAction() {
        //TODO
        //plant should die instantly
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
