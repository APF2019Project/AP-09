package controller;

import view.*;
import model.Account;

import java.util.ArrayList;
import java.util.Collections;

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
            show.showMenu(request.getCurrentMenu());
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
                //TODO
                break;
            //todo do the rest exept play
        }
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

    private void help() {
        Output.getInstance().printHelp(Request.getInstance().getCurrentMenu());
    }



    private void mainMenu(MainMenuCommand lastMainMenuCommand) { //todo it's just example ,  fit it into structure
        switch (lastMainMenuCommand) {
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

    private void profile() { //todo it's just example ,  fit it into structure
        Request.getInstance().nextMenu(Menu.PROFILE);
    }

    private void play() { //todo don't touch this for now because battle is not ready yet!
        Request.getInstance().nextMenu(Menu.PLAY);
    }

    private void shop() { //todo don't touch this it's mine
        Request.getInstance().nextMenu(Menu.SHOP);
    }


    public void endGame() {
        endGame = true;
    }

    private void exit() {
        if (Request.getInstance().getCurrentMenu().equals(MAJOR_LOGIN)) {
            endGame();
            return;
        }
        menus.remove(menus.size() - 1);
    }

    private void leaderBoard() {
        Collections.sort(Account.getAllAccount());
        for (Account account : Account.getAllAccount()) {
            System.out.println(account.getUserName() + " " + account.getKilledZombies()); //todo make a function in the Output instead of printing directly in controller
        }
        Request.getInstance().nextMenu(Menu.LEADER_BOARD);
    }

    private void signUp(MajorLoginCommand loginCommand) { //todo it's just example ,  fit it into structure
        String name = loginCommand.getName();
        String password = loginCommand.getPassword();
        int flagOfExistence = 0;
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name)) {
                flagOfExistence = 1;
            }
        }
        if (flagOfExistence == 0) {
            Account.getAllAccount().add(new Account(name, password));

        } else
            System.out.println("already exist");

    }

    private void loginMenu(LoginCommand loginCommand) {
        String name = loginCommand.getName();
        String password = loginCommand.getPassword();
        int flagOfExistence = 0;
        for (Account account : Account.getAllAccount()) {
            if (account.getUserName().equals(name)) {
                Account.setLoggedAccount(account);
                flagOfExistence = 1;
            }
        }
        if (flagOfExistence == 1) {
            Request.getInstance().nextMenu(MAJOR_LOGIN);
            Request.getInstance().nextMenu(Menu.MAIN);
        } else
            Output.getInstance().invalidAccount();
    }



    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}