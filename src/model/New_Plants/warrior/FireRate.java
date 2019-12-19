package model.New_Plants.warrior;

public class FireRate {

    private int bulletCount;
    private int turnCount;

    public FireRate(int bulletCount, int turnCount) {
        this.bulletCount = bulletCount;
        this.turnCount = turnCount;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
