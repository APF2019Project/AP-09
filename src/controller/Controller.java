package controller;

import command.LoginCommand;
import command.Menu;
import model.Account;
import view.Input;

import java.util.ArrayList;

public class Controller {
    private final static Controller instance  = new Controller();
    private boolean endGame = false;
    private ArrayList<Menu> menus = new ArrayList<>();
    private Controller(){
        menus.add(Menu.LOGIN);
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
            case LOGIN:
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
                break;
            case SIGN_UP:
                break;
        }
    }

    private void login(LoginCommand loginCommand){
        String name  = loginCommand.getName();
        String password = loginCommand.getPassword();
        Account account = new Account(name,password);
        Account.setLoggedAccount(account);
        menus.add(Menu.MAIN);
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