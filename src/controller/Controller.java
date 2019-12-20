package controller;

import command.LeaderBoardCommand;
import command.LoginCommand;
import command.MainMenuCommand;
import command.Menu;
import model.Account;
import view.Input;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private final static Controller instance = new Controller();
    private boolean endGame = false;
    private ArrayList<Menu> menus = new ArrayList<>();

    private Controller() {
        menus.add(Menu.MAJOR_LOGIN);
    }

    public static Controller getInstance() {
        return instance;
    }

    public void main() {
        while (!endGame) {
            System.out.println(getCurrentMenu());
            Input.getInstance().getCommandFromUserInConsole();

            if (firstCheck())
                continue;
            System.out.println("after check");
            getCommandEnumFromInput();


            //TODO call Output
        }
        Account.toJson();
    }

    private boolean firstCheck() {
        System.out.println("check");
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
        switch (getCurrentMenu()) {
            case SHOP:
            case PLAY:
            case LEADER_BOARD:
            case LOGIN:
            case MAIN:
            case MAJOR_LOGIN:
            case PROFILE:
            case SIGN_UP:
        }
    }

    private void getCommandEnumFromInput() {
        switch (getCurrentMenu()) {
            case MAJOR_LOGIN:
                loginMenu(Input.getInstance().getLastMajorLoginCommand());
                break;
            case MAIN:
                mainMenu(Input.getInstance().getLastMainMenuCommand());
                break;
            case LEADER_BOARD:
                leaderBoard(Input.getInstance().getLastLeaderBoardCommand());
                break;
        }
    }

    private void leaderBoard(LeaderBoardCommand leaderBoardCommand) {
        switch (leaderBoardCommand) {
            case EXIT:
                exit();
                break;
        }
    }

    private void mainMenu(MainMenuCommand lastMainMenuCommand) {
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

    private void profile() {
        nextMenu(Menu.PROFILE);
    }

    private void play() {
        nextMenu(Menu.PLAY);
    }

    private void shop() {
        nextMenu(Menu.SHOP);
    }

    private void loginMenu(LoginCommand loginCommand) {
        switch (loginCommand) {
            case LOGIN:
                login(loginCommand);
                break;
            case EXIT:
                endGame();
                break;
            case SIGN_UP:
                signUp(loginCommand);
                break;
            case LEADER_BOARD:
                leaderBoard();
        }
    }

    public void endGame() {
        endGame = true;
    }

    private void exit() {
        if (getCurrentMenu().equals(Menu.MAJOR_LOGIN)) {
            endGame();
            return;
        }
        menus.remove(menus.size() - 1);
    }

    private void leaderBoard() {
        Collections.sort(Account.getAllAccount());
        for (Account account : Account.getAllAccount()) {
            System.out.println(account.getUserName() + " " + account.getKilledZombies());
        }
        nextMenu(Menu.LEADER_BOARD);
    }

    private void signUp(LoginCommand loginCommand) {
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

    private void login(LoginCommand loginCommand) {
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
            nextMenu(Menu.MAIN);
        } else
            System.out.println("invalid account");
    }

    private void nextMenu(Menu menu) {
        menus.add(menu);
    }

    public Menu getCurrentMenu() {
        return menus.get(menus.size() - 1);
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}