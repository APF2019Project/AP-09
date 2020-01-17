package model;

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

    public boolean equals(Player player) {
        if (this.getAccount().getUserName().equals(player.getAccount().getUserName()))
            if (this.getAccount().getPassWord().equals(player.getAccount().getPassWord()))
                return true;

        return false;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
