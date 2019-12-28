package view;

import model.Account;
import model.card.Card;

public class Output {
    private static Output instance = new Output();

    private Output() {

    }

    public void printHelp(Menu menu) {
        switch (menu) {
            case MAJOR_LOGIN:
                majorLoginHelp();
                break;
            case MAIN:
                break;
            case SHOP:
                shopHelp();
                break;
            case PLAY:
                break;
            case PROFILE:
                profileHelp();
                break;
        }
    }

    private void profileHelp() {
        System.out.println("change your account");
        System.out.println("rename your username");
        System.out.println("delete your profile");
        System.out.println("show your username");
        System.out.println("create new profile");
    }

    public static Output getInstance() {
        return instance;
    }

    public void invalidAccount() {
        System.out.println("invalid account");
    }

    public void invalidCard() {
        System.out.println("invalid card");
    }

    public void soldCard() {
        System.out.println("already sold!");
    }

    public void boughtSuccessfully() {
        System.out.println("the card bought successfully!");
    }

    public void notEnoughMoney() {
        System.out.println("not enough money!");
    }

    public void showMenu(Menu menu) {
        System.out.println(" *** " + menu.name() + " Menu *** ");
    }

    public void showShop() {
        System.out.println("available cards:");
        for (Card card : Card.getCards()) {
            if (!card.isBought()) {
                System.out.println(card.getCardType() + " " + card.getCardName() + "     price : " + card.getPrice());
            }
        }
    }

    public void showBoughtCards() {
        System.out.println("you have:");
        for (Card card : Card.getCards()) {
            if (card.isBought()) {
                System.out.println(card.getCardType() + " " + card.getCardName());
            }
        }
    }

    public void showAccountMoney() {
        System.out.println("you have  " + Account.getLoggedAccount().getMoney() + "  $");
    }

    public void majorLoginHelp() {
        System.out.println("The Menus:");
        System.out.println(" *** Login Menu ***");
        System.out.println(" *** Sign up Menu ***");
        System.out.println(" *** LeaderBoard Menu ***");
        System.out.println(" *** Exit ***");
    }

    public void shopHelp() {
        System.out.println("available cards:");
        for (Card card : Card.getCards()) {
            if (!card.isBought()) {
                System.out.println(card.getCardName() + "     price : " + card.getPrice());
            }
        }
    }

    public void invalidSigning() {
        System.out.println("already exists");
    }

    public void printLeaderBoard(Account account) {
        System.out.println(account.getUserName() + " " + account.getKilledZombies());
    }

    public void showHand() {
        System.out.println("your hand is :");
        for(Card card : Account.getLoggedAccount().getDeck()){
            System.out.println(card.getCardName());
        }
    }

    public void showCollection() {
        System.out.println("your collection is :");
        for(Card card : Account.getLoggedAccount().getAllCard()){
            System.out.println(card.getCardName());
        }
    }
    public void invalidCommand(){
        System.out.println("invalid command");
    }
}