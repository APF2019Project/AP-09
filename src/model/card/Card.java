package model.card;

import java.util.ArrayList;

abstract public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private int price;
    private boolean isBought = false;
    private CardType cardType;
    private String cardName;

    public static Card targetCard(String cardName){
        if (cards.stream().anyMatch(card -> card.getCardName().equals(cardName))) {
            Card card = (Card) Card.cards.stream().filter(card1 -> card1.getCardName().equals(cardName)).toArray()[0];
            return card ;
        }
        else
            return null;

    }

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