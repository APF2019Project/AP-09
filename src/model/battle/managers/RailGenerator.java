package model.battle.managers;

import com.rits.cloning.Cloner;
import model.New_Plants.Plant;
import model.New_Plants.PlantKind;
import model.card.Card;
import model.card.CardOfPlant;

import java.util.ArrayList;
import java.util.Random;

public class RailGenerator {

    private Random random = new Random();
    private ArrayList<CardOfPlant> cardOfPlants = new ArrayList<>();
    private int randomTurn;
    private int turnCounter;

    public void generatePlant() {
        if (this.turnCounter == this.randomTurn) {
            if (this.cardOfPlants.size() <= 10)
                this.randomPlantGenerator();
            this.randomTurnGenerator();
            this.turnCounter = 0;
        } else {
            this.turnCounter += 1;
        }

    }

    private void randomTurnGenerator() {
        this.randomTurn = 2 + this.random.nextInt(3);
    }

    private void randomPlantGenerator() {
        int randomIndex = this.random.nextInt(Plant.getPlants().size());
        // TODO Selected Plant should not be SunFlower, so fix following while condition
        while (Plant.getPlants().get(randomIndex).getPlantKind() == PlantKind.OTHER) {
            randomIndex = this.random.nextInt(Plant.getPlants().size());
        }
        Cloner cloner = new Cloner();
        Plant plant = cloner.deepClone(Plant.getPlants().get(randomIndex));
        this.cardOfPlants.add(new CardOfPlant(plant));
    }

    public void removeCard(CardOfPlant card) {
        this.cardOfPlants.remove(card);
    }


}
