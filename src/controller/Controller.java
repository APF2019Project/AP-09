package controller;

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
            //TODO call Input Class to get input's command and get an Enum

            //TODO process

            //TODO call Output
        }
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}