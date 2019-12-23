package view;

import javafx.scene.control.Accordion;
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
                break;
            case LEADER_BOARD:
                break;
        }
    }

    public static Output getInstance() {
        return instance;
    }

    public void invalidAccount() {
        System.out.println("invalid account");
    }

    public void majorLoginHelp() {
        System.out.println(" *** Major Login Menu ***");
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
        account.getUserName() + " " + account.getKilledZombies()
    }
}