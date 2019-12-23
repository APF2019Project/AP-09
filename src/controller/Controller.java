package controller;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import model.card.Card;
import sun.font.DelegatingShape;
import view.*;
import model.Account;

import java.util.ArrayList;
import java.util.Collections;

import static view.Menu.MAIN;
import static view.Menu.MAJOR_LOGIN;

public class Controller {
    private final static Controller instance = new Controller();
    private boolean endGame = false;
    private ArrayList<Menu> menus = new ArrayList<>();
    private static Show show = Show.getInstance();

    private Controller() {
        menus.add(MAJOR_LOGIN);
    }

    public static Controller getInstance() {
        return instance;
    }

    public void main() {
        Request request = Request.getInstance() ;
        while (!endGame) {

            if (firstCheck())
                continue;
            Output.getInstance().showMenu(request.getCurrentMenu());
            request.getRequest();
            commandManagement(request, request.getCurrentMenu());

            //TODO call Output(ali it's not for you :) )
        }
        Account.toJson();
    }

    private void commandManagement(Request request, Menu currentMenu) {
        switch (currentMenu){
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
            //todo do the rest except play and shop
        }
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
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name) && account.getPassWord().equals(password)) {
                Account.getAllAccount().remove(account);
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
            case EXIT:
                endGame();
                break;
            case SIGN_UP:
                Request.getInstance().nextMenu(Menu.SIGN_UP);
                break;
            case LEADER_BOARD:
                Request.getInstance().nextMenu(Menu.LEADER_BOARD);
                break;
            case HELP:
                help();
                break;
        }
    }


    private boolean firstCheck() {
        if (Input.getInstance().isInvalidCommand()) {
            Input.getInstance().setInvalidCommand(false);
            return true;
        }
        if (Input.getInstance().isExit()) {
            exit();
            Input.getInstance().setExit(false);
            return true;
        }
        if (Input.getInstance().isHelp()) {
            help();
            Input.getInstance().setHelp(false);
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

    public void profile() { //todo it's just example ,  fit it into structure
        Request.getInstance().nextMenu(Menu.PROFILE);
    }

    public void play() { //todo don't touch this for now because battle is not ready yet!
        Request.getInstance().nextMenu(Menu.PLAY);
    }

    public void shop() { //todo don't touch this it's mine
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
        menus.remove(menus.size() - 1);
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
            Account.getAllAccount().add(new Account(name, password));
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
        } else
            Output.getInstance().invalidAccount();
    }
    public void  shopMenu(ShopCommand shopCommand){
        switch (shopCommand){
            case BUY:
                String cardNameFromConsole = shopCommand.getName() ;
                Boolean isContainCard = Card.getCards().stream().anyMatch(card -> card.getCardName().equals(cardNameFromConsole)) ;
                if (!isContainCard)
                    Output.getInstance().invalidCard();
                else{
                    Card targetCard = (Card) Card.getCards().stream().filter(card -> card.getCardName().equals(cardNameFromConsole)).toArray()[0] ;
                    if (targetCard.isBought())
                        Output.getInstance().soldCard();
                    else{
                        if (targetCard.getPrice()<= Account.getLoggedAccount().getMoney()) {
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

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}