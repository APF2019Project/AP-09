package model.card;

import model.New_Zombies.Zombie;

import java.util.ArrayList;

public class CardOfZombie extends Card {
    private static ArrayList<CardOfZombie> zombieCards = new ArrayList<>();
    private Zombie zombie;

    public static ArrayList<CardOfZombie> getZombieCards() {
        return zombieCards;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public CardOfZombie(Zombie zombie) {
        super(CardType.ZOMBIE);
        this.zombie = zombie;
        this.setCardName(zombie.getZombieName());
        calculatePrice();
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }

    public static void defineAllCards() {
        for (Zombie zombie : Zombie.getZombies()) {
            zombieCards.add(new CardOfZombie(zombie));
        }
    }

    @Override
    public void calculatePrice() {
        this.setPrice((this.zombie.getSpeed() + 1) * this.zombie.getHealthPoint() * 10);
    }

}
