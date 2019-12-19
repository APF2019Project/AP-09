package model.New_Plants;

import constants.Constants;
import model.Cell;

public class Bullet {

    private int bulletSpeed = Constants.BULLET_SPEED;
    private Cell position;

    public Bullet() {
    }

    public void fire(){

    }


    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }
}
