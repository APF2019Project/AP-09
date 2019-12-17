package controller;

import command.LoginCommand;
import command.Menu;
import model.Account;
import view.Input;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private final static Controller instance  = new Controller();
    private boolean endGame = false;
    private ArrayList<Menu> menus = new ArrayList<>();
    private Controller(){
        menus.add(Menu.MAJORLOGIN);
    }
    public static Controller getInstance() {
        return instance;
    }

    public void main(){
        while (!endGame) {
            System.out.println(getCurrentMenu());
            Input.getInstance().getCommandFromUserInConsole();

            getCommandEnumFromInput();
            //TODO call Output
        }
    }



    private void login(String command){


    }

    private void getCommandEnumFromInput(){
        switch (getCurrentMenu()){
            case MAJORLOGIN:
                loginMenu(Input.getInstance().getLastLoginCommand());
                break;
        }
    }

    private void loginMenu(LoginCommand loginCommand){
        switch (loginCommand){
            case LOGIN:
                login(loginCommand);
                break;
            case EXIT:
                exit() ;
                break;
            case SIGN_UP:
                signUp(loginCommand);
                break;
            case LEADERBOARD:
                leaderBoard();
        }
    }
    public void exit(){
        endGame = true ;
    }

    private void leaderBoard() {
        Collections.sort(Account.getAllAccount());
        for (Account account:Account.getAllAccount()) {
            System.out.println(account.getUserName() + " " + account.getKilledZombies());
        }
    }

    private void signUp(LoginCommand loginCommand) {
        String name  = loginCommand.getName();
        String password = loginCommand.getPassword();
        int flagOfExistence = 0 ;
        for (Account account: Account.getAllAccount()) {
            if (account.getUserName().equals(name)){
                flagOfExistence = 1 ;
            }
        }
        if (flagOfExistence==0){
            Account.getAllAccount().add(new Account(name, password));
        }else
            System.out.println("already exist");

    }

    private void login(LoginCommand loginCommand){
        String name  = loginCommand.getName();
        String password = loginCommand.getPassword();
        int flagOfExistence = 0 ;
        for (Account account: Account.getAllAccount()) {
            if (account.getUserName().equals(name)){
                Account.setLoggedAccount(account);
                flagOfExistence = 1 ;
            }
        }
        if (flagOfExistence==1){
            menus.add(Menu.MAIN);
        }else
            System.out.println("invalid account");
    }

    public Menu getCurrentMenu(){
        return menus.get(menus.size()-1);
    }
    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}