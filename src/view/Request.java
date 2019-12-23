package view;

import model.card.Card;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Request {
    private static final Request request = new Request();
    private ArrayList<Menu> menus = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private MajorLoginCommand lastMajorLoginCommand;
    private LoginCommand lastLoginCommand;
    private ShopCommand lastShopCommand ;

    private Request() {
        menus.add(Menu.MAJOR_LOGIN);
    }

    public static Request getInstance() {
        return request;
    }

    public void getRequest() {
        String command = scanner.nextLine();
        transferCommandToRightPlace(command);
    }

    public void transferCommandToRightPlace(String command) {
        switch (getCurrentMenu()) {
            case MAJOR_LOGIN:
                majorLogin(command.toLowerCase());
                break;
            case LOGIN:
                login(command.toLowerCase());
        }
    }

    public void shop(String command) {
        for (int i = 0; i < Patterns.shopPatterns.length; i++) {
            Matcher matcher = Patterns.shopPatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfShop(matcher, i);
                return;
            }
        }
        //Todo handle Errors
    }

    public void setCommandOfShop(Matcher matcher, int i){
        if (i==3){
            lastShopCommand = ShopCommand.values()[i];
            lastShopCommand.setName(matcher.group(1));
        }else
            lastShopCommand = ShopCommand.values()[i];
    }

    public void login(String command) {
        Matcher matcher = Patterns.loginPattern[0].matcher(command);
        if (matcher.matches()) {
            LoginCommand loginCommand = LoginCommand.USERNAME_PASSWORD;
            loginCommand.setName(matcher.group(1));
            loginCommand.setPassword(matcher.group(2));
        }
        //TODO error
    }


    public void majorLogin(String command) {
        for (int i = 0; i < Patterns.majorLoginPatterns.length; i++) {
            Matcher matcher = Patterns.majorLoginPatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfMajorLogin(i);
                return;
            }
        }
        //Todo handle Errors
    }

    public void setCommandOfMajorLogin(int i) {
        lastMajorLoginCommand = MajorLoginCommand.values()[i];
    }

    public MajorLoginCommand getLastMajorLoginCommand() {
        return lastMajorLoginCommand;
    }

    public void nextMenu(Menu menu) {
        menus.add(menu);
    }

    public Menu getCurrentMenu() {
        return menus.get(menus.size() - 1);
    }

    public LoginCommand getLastLoginCommand() {
        return lastLoginCommand;
    }

    public ShopCommand getLastShopCommand() {
        return lastShopCommand;
    }

    public void setLastShopCommand(ShopCommand lastShopCommand) {
        this.lastShopCommand = lastShopCommand;
    }
}