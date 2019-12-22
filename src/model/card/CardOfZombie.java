package model.card;

import model.New_Zombies.Zombie;

public class CardOfZombie extends Card {
    private Zombie zombie ;

    public Zombie getZombie() {
        return zombie;
    }
    public CardOfZombie(Zombie zombie){
        this.zombie = zombie ;
        calculatePrice();
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }

    @Override
    public void defineAllCards(){
        for (Zombie zombie: Zombie.getZombies()) {
            Card.getCards().add(new CardOfZombie(zombie)) ;
        }
    }

@Override
    public  void calculatePrice(){
        this.setPrice((this.zombie.getSpeed()+1)* this.zombie.getHealthPoint() * 10);
    }

}
