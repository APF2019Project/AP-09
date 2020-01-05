package controller;

import model.card.Card;
import view.*;
import model.Account;

import java.util.ArrayList;
import java.util.Collections;

import static view.Menu.MAIN;
import static view.Menu.MAJOR_LOGIN;

public class Controller {
    private final static Controller instance = new Controller();
    private boolean endGame = false;

    private Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }

    public void main() {
        Request request = Request.getInstance();
        Output.getInstance().showMenu(request.getCurrentMenu());
        while (!endGame) {
            request.getRequest();
            if (firstCheck())
                continue;
            commandManagement(request, request.getCurrentMenu());

        }
        Account.toJson();
    }

    private void commandManagement(Request request, Menu currentMenu) {
        switch (currentMenu) {
            case MAJOR_LOGIN:
                majorLoginMenu(request.getLastMajorLoginCommand());
                break;
            case LOGIN:
                loginMenu(request.getLastLoginCommand());
                break;
            case SIGN_UP:
                signUp(request.getLastSignUpCommand());
                break;
            case LEADER_BOARD:
                leaderBoard();
                break;
            case MAIN:
                mainMenu(request.getLastMainMenuCommand());
                break;
            case PROFILE:
                profileMenu(request.getLastProfileMenuCommand());
                break;
            case COLLECTION:
                collectionMenu(request.getLastCollectionCommand());
                break;
            case SHOP:
                shopMenu(request.getLastShopCommand());
                break;
            case DAY_MODE:
                dayPlayMenu(request.getLastDayAndPoolCommand());
                break;
            case PLAY:
                playMenu(request.getLastPlayCommand(), request.getLastCollectionCommand()) ;
                break;
            case PVP_MODE:

                break;
            case RAIL_MODE:
                break;
            case WATER_MODE:
                break;
            case ZOMBIE_MODE:
                break;
        }
    }

    private void playMenu(PlayCommand playCommand, CollectionCommand collectionCommand) {
        switch (playCommand){
            case DAY:
                collectionCommand.setNextPlayMenu(Menu.DAY_MODE);
                Request.getInstance().nextMenu(Menu.COLLECTION);
                break;
            case RAIL:
                collectionCommand.setNextPlayMenu(Menu.RAIL_MODE);
                Request.getInstance().nextMenu(Menu.COLLECTION);
                break;
            case ZOMBIE:
                collectionCommand.setNextPlayMenu(Menu.ZOMBIE_MODE);
                Request.getInstance().nextMenu(Menu.COLLECTION);
                break;
            case PVP:
                collectionCommand.setNextPlayMenu(Menu.PVP_MODE);
                Request.getInstance().nextMenu(Menu.COLLECTION);
                break;
            case WATER:
                collectionCommand.setNextPlayMenu(Menu.WATER_MODE);
                Request.getInstance().nextMenu(Menu.COLLECTION);
                break;
        }
    }

    private void dayPlayMenu(DayAndPoolCommand dayAndPoolCommand) {
        switch (dayAndPoolCommand){
            case PLANT:
                break;
            case REMOVE:
                break;
            case SELECT:
                break;
            case END_TURN:
                break;
            case SHOW_HAND:
                break;
            case SHOW_LAWN:
                break;
        }
    }

    private void collectionMenu(CollectionCommand collectionCommand) {
        switch (collectionCommand){
            case SHOW_HAND:
                Output.getInstance().showHand();
                break;
            case PLAY:
                Request.getInstance().nextMenu(collectionCommand.getNextPlayMenu());
                break;
            case REMOVE:
                removeCard(collectionCommand);
                break;
            case SELECT:
                selectCard(collectionCommand);
                break;
            case SHOW_COLLECTION:
                Output.getInstance().showCollection();
                break;
        }
    }

    public void removeCard(CollectionCommand collectionCommand) {
        Account account = Account.getLoggedAccount();
        for(Card card : account.getDeck()){
            if(card.getCardName().equals(collectionCommand.getName())){
                account.getDeck().remove(card);
                System.out.println("you have removed a card");
                return;
            }
        }
        Output.getInstance().invalidCard();
    }

    public void selectCard(CollectionCommand collectionCommand) {
        Account account = Account.getLoggedAccount();
        for(Card card : account.getAllCard()){
            if(card.getCardName().equals(collectionCommand.getName())){
                account.getDeck().add(card);
                System.out.println("you have selected a card");
                return;
            }
        }
        Output.getInstance().invalidCard();
    }

    private void profileMenu(ProfileMenuCommand profileMenuCommand) {
        switch (profileMenuCommand) {
            case CHANGE:
                changeAccount(profileMenuCommand);
                break;
            case SHOW:
                showCurrentAccount();
                break;
            case CREATE:
                createNewProfile(profileMenuCommand);
                break;
            case DELETE:
                deleteProfile(profileMenuCommand);
                break;
            case RENAME:
                renameProfile(profileMenuCommand);
                break;
            case HELP:
                help();
                break;
        }
    }

    private void renameProfile(ProfileMenuCommand profileMenuCommand) {
        String name = profileMenuCommand.getName();
        Account account = Account.getLoggedAccount();
        account.setUserName(name);
    }

    private void deleteProfile(ProfileMenuCommand profileMenuCommand) {
        String name = profileMenuCommand.getName();
        String password = profileMenuCommand.getPassword();
        int flagOfExistence = 0;
        ArrayList<Account> accounts = Account.getAllAccount();
        for (Account account : accounts) {
            if (account.getUserName().equals(name) && account.getPassWord().equals(password)) {
                Output.getInstance().successfullyDeleted();
                Account.removeAccount(account);
                if(name.equals(Account.getLoggedAccount().getUserName())) {
                    Request.getInstance().nextMenu(MAJOR_LOGIN);
                    Account.setLoggedAccount(null);
                    System.out.println("*** MAJOR_LOGIN Menu ***");
                }
                flagOfExistence = 1;
                break;
            }
        }
        if (flagOfExistence != 1)
            Output.getInstance().invalidAccount();

    }

    private void createNewProfile(ProfileMenuCommand profileMenuCommand) {
        String name = profileMenuCommand.getName();
        String password = profileMenuCommand.getPassword();
        int flagOfExistence = 0;
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name)) {
                flagOfExistence = 1;
            }
        }
        if (flagOfExistence == 0) {
            Account.getAllAccount().add(new Account(name, password));

        } else
            Output.getInstance().invalidSigning();
    }

    private void showCurrentAccount() {
        Account account = Account.getLoggedAccount();
        System.out.println(account.getUserName());
    }

    private void changeAccount(ProfileMenuCommand profileMenuCommand) {
        String name = profileMenuCommand.getName();
        String password = profileMenuCommand.getPassword();
        int flagOfExistence = 0;
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name) && account.getPassWord().equals(password)) {
                Account.setLoggedAccount(account);
                flagOfExistence = 1;
            }
        }
        if (flagOfExistence != 1)
            Output.getInstance().invalidAccount();

    }

    private void majorLoginMenu(MajorLoginCommand majorLoginCommand) {
        switch (majorLoginCommand) {
            case LOGIN:
                Request.getInstance().nextMenu(Menu.LOGIN);
                break;
            case SIGN_UP:
                Request.getInstance().nextMenu(Menu.SIGN_UP);
                Output.getInstance().showMenu(Menu.SIGN_UP);
                break;
            case LEADER_BOARD:
                Request.getInstance().nextMenu(Menu.LEADER_BOARD);
                break;
        }
    }


    private boolean firstCheck() {
        if (Request.getInstance().isInvalidCommand()) {
            Output.getInstance().invalidCommand();
            Request.getInstance().setInvalidCommand(false);
            return true;
        }
        if (Request.getInstance().isExit()) {
            exit();
            Output.getInstance().showMenu(Request.getInstance().getCurrentMenu());
            Request.getInstance().setExit(false);
            return true;
        }
        if (Request.getInstance().isHelp()) {
            help();
            Request.getInstance().setHelp(false);
            return true;
        }
        return false;
    }

    public void help() {
        Output.getInstance().printHelp(Request.getInstance().getCurrentMenu());
    }


    public void mainMenu(MainMenuCommand mainMenuCommand) {
        switch (mainMenuCommand) {
            case PROFILE:
                profile();
                break;
            case PLAY:
                play();
                break;
            case SHOP:
                shop();
                break;
        }
    }

    public void profile() {
        System.out.println("*** Profile ***");
        Request.getInstance().nextMenu(Menu.PROFILE);
    }

    public void play() {
        Request.getInstance().nextMenu(Menu.PLAY);
    }

    public void shop() {
        Request.getInstance().nextMenu(Menu.SHOP);
    }


    public void endGame() {
        endGame = true;
    }

    public void exit() {
        if (Request.getInstance().getCurrentMenu().equals(MAJOR_LOGIN)) {
            endGame();
            return;
        }
        Request.getInstance().getMenus().remove(Request.getInstance().getMenus().size() - 1);
    }

    public void leaderBoard() {
        Collections.sort(Account.getAllAccount());
        for (Account account : Account.getAllAccount()) {
            Output.getInstance().printLeaderBoard(account);
        }
        Request.getInstance().nextMenu(Menu.LEADER_BOARD);
    }

    public void signUp(SignUpCommand signUpCommand) {
        String name = signUpCommand.getName();
        String password = signUpCommand.getPassword();
        int flagOfExistence = 0;
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name)) {
                flagOfExistence = 1;
            }
        }
        if (flagOfExistence == 0) {
            Account account = new Account(name, password);
            Account.setLoggedAccount(account);
            System.out.println("account created :)))))");
            System.out.println("***********  WELCOME TO THE GAME  ***********");
            Request.getInstance().nextMenu(MAJOR_LOGIN);
            Request.getInstance().nextMenu(MAIN);

        } else
            Output.getInstance().invalidSigning();
    }

    public void loginMenu(LoginCommand loginCommand) {
        String name = loginCommand.getName();
        String password = loginCommand.getPassword();
        int flagOfExistence = 0;
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name) && account.getPassWord().equals(password)) {
                Account.setLoggedAccount(account);
                flagOfExistence = 1;
            }
        }
        if (flagOfExistence == 1) {
            Request.getInstance().nextMenu(MAJOR_LOGIN);
            Request.getInstance().nextMenu(MAIN);
            System.out.println("you logged in :)) ");
        } else
            Output.getInstance().invalidAccount();
    }

    public void shopMenu(ShopCommand shopCommand) {
        switch (shopCommand) {
            case BUY:
                String cardNameFromConsole = shopCommand.getName();
                Boolean isContainCard = Card.getCards().stream().anyMatch(card -> card.getCardName().equals(cardNameFromConsole));
                if (!isContainCard)
                    Output.getInstance().invalidCard();
                else {
                    Card targetCard = (Card) Card.getCards().stream().filter(card -> card.getCardName().equals(cardNameFromConsole)).toArray()[0];
                    if (targetCard.isBought())
                        Output.getInstance().soldCard();
                    else {
                        if (targetCard.getPrice() <= Account.getLoggedAccount().getMoney()) {
                            Account.getLoggedAccount().decreaseMoney(targetCard.getPrice());
                            Account.getLoggedAccount().getAllCard().add(targetCard);
                            targetCard.setBought(true);
                            Output.getInstance().boughtSuccessfully();
                        } else
                            Output.getInstance().notEnoughMoney();
                    }
                }
                break;
            case MONEY:
                Output.getInstance().showAccountMoney();
                break;
            case SHOW_SHOP:
                Output.getInstance().showShop();
                break;
            case SHOW_BOUGHT_CARDS:
                Output.getInstance().showBoughtCards();
                break;
        }

    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

}