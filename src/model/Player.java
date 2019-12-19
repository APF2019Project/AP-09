package model;

import model.New_Zombies.Zombie;
import model.New_Plants.Plant;

import java.util.ArrayList;

public class Player {
    private Account account;
    private Deck deck;
    private int numberPlayerInGame;
    private int sun;

    public ArrayList<Plant> getPlants() {
        return this.deck.getPlants();
    }

    public ArrayList<Zombie> getZombies() {
        return this.deck.getZombies();
    }

    public void decreaseSun(int number) {
        this.sun -= number;
    }

    public void increaseSun(int number) {
        this.sun += number;
    }

    public int getNumberPlayerInGame() {
        return numberPlayerInGame;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public void setNumberPlayerInGame(int numberPlayerInGame) {
        this.numberPlayerInGame = numberPlayerInGame;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
