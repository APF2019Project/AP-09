package model.card;

import java.util.ArrayList;

abstract public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private int price;
    private boolean isBought = false;
    private CardType cardType;
    private String cardName;

    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    abstract public void calculatePrice();

    abstract public void defineAllCards(); //Todo this function must be called at the first of the program

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}