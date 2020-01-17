package model.card;

import model.New_Plants.Plant;

import java.util.ArrayList;

public class CardOfPlant extends Card {
    private static ArrayList<CardOfPlant> plantCards = new ArrayList<>();
    private Plant plant;

    public CardOfPlant(Plant plant) {
        super(CardType.PLANT);
        this.plant = plant;
        this.setCardName(plant.getPlantName());
        calculatePrice();
    }

    public static ArrayList<CardOfPlant> getPlantCards() {
        return plantCards;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public static void defineAllCards() {
        for (Plant plant : Plant.getPlants()) {
            plantCards.add(new CardOfPlant(plant));
        }
    }

    @Override
    public void calculatePrice() {
        this.setPrice(this.plant.getSunUsage() * this.plant.getCoolDown() * this.plant.getHealthPoint() + 1);
    }
}
