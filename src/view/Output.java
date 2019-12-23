package view;

import model.card.Card;

public class Output {
    private static Output instance = new Output();

    private Output() {

    }

    public void printHelp(Menu menu) {
        switch (menu) {
            case MAJOR_LOGIN:
                majorLoginHelp(menu);
                break;
            case MAIN:
                break;
            case SIGN_UP:
                break;
            case LOGIN:
                break;
            case SHOP:
                System.out.println("available cards:");
                for (Card card : Card.getCards()) {
                    if (!card.isBought()) {
                        System.out.println(card.getCardName() + "     price : " + card.getPrice());
                    }
                }
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

    public void majorLoginHelp(Menu menu) {
        System.out.println(" *** Major Login Menu ***");
        System.out.println("The Menus:");
        System.out.println(" *** Login Menu ***");
        System.out.println(" *** Sign up Menu ***");
        System.out.println(" *** LeaderBoard Menu ***");
        System.out.println(" *** Exit ***");
    }
}