package model;

import model.New_Zombies.Zombie;
import model.New_Plants.Plant;
import model.card.Card;

import java.util.ArrayList;

public class Player {
    private Account account;
    private int numberPlayerInGame;
    private int sun;
    private ArrayList<Card> deck = new ArrayList<>();
    

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
