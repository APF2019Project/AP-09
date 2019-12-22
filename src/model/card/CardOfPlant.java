package model.card;

import model.New_Plants.Plant;

public class CardOfPlant extends Card {
    private Plant plant ;

    public CardOfPlant(Plant plant){
        this.plant = plant ;
        calculatePrice();
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Override
    public void defineAllCards(){
        for (Plant plant: Plant.getPlants()) {
            Card.getCards().add(new CardOfPlant(plant)) ;
        }
    }

    @Override
    public void calculatePrice() {
        this.setPrice(this.plant.getSunUsage()*this.plant.getCoolDown()*this.plant.getHealthPoint()+1);
    }
}
