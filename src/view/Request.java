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
    private SignUpCommand lastSignUpCommand;
    private MainMenuCommand lastMainMenuCommand;
    private ProfileMenuCommand lastProfileMenuCommand;
    private ShopCommand lastShopCommand;
    private CollectionCommand lastCollectionCommand;

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

    public ProfileMenuCommand getLastProfileMenuCommand() {
        return lastProfileMenuCommand;
    }

    public MainMenuCommand getLastMainMenuCommand() {
        return lastMainMenuCommand;
    }


    public void transferCommandToRightPlace(String command) {
        switch (getCurrentMenu()) {
            case MAJOR_LOGIN:
                majorLogin(command.toLowerCase());
                break;
            case LOGIN:
                login(command.toLowerCase());
                break;
            case SIGN_UP:
                signUp(command.toLowerCase());
                break;
            case COLLECTION:
                collection(command.toLowerCase());
        }
    }

    public void collection(String command) {
        for (int i = 0; i < Patterns.collectionPatterns.length; ++i) {
            Matcher matcher = Patterns.collectionPatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfCollection(matcher, i);
                return;
            }
        }
        //TODO handle errors
    }

    private void setCommandOfCollection(Matcher matcher, int i) {
        if (i == 2) {
            lastCollectionCommand = CollectionCommand.values()[i];
            lastCollectionCommand.setName(matcher.group(1));
        } else if (i == 3) {
            lastCollectionCommand = CollectionCommand.values()[i];
            lastCollectionCommand.setName(matcher.group(1));
        } else
            lastShopCommand = ShopCommand.values()[i];
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

    public void setCommandOfShop(Matcher matcher, int i) {
        if (i == 3) {
            lastShopCommand = ShopCommand.values()[i];
            lastShopCommand.setName(matcher.group(1));
        } else
            lastShopCommand = ShopCommand.values()[i];
    }


    public void signUp(String command) {
        Matcher matcher = Patterns.signUpPatterns[0].matcher(command);
        if (matcher.matches()) {
            lastSignUpCommand = SignUpCommand.USERNAME_PASSWORD;
            lastSignUpCommand.setName(matcher.group(0));
            lastSignUpCommand.setPassword(matcher.group(1));
        }
        // TODO error
    }

    public void login(String command) {
        Matcher matcher = Patterns.loginPattern[0].matcher(command);
        if (matcher.matches()) {
            lastLoginCommand = LoginCommand.USERNAME_PASSWORD;
            lastLoginCommand.setName(matcher.group(0));
            lastLoginCommand.setPassword(matcher.group(1));
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

    public SignUpCommand getLastSignUpCommand() {
        return lastSignUpCommand;
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

    public CollectionCommand getLastCollectionCommand() {
        return lastCollectionCommand;
    }

    public void setLastCollectionCommand(CollectionCommand lastCollectionCommand) {
        this.lastCollectionCommand = lastCollectionCommand;
    }

    public void setLastProfileMenuCommand(ProfileMenuCommand lastProfileMenuCommand) {
        this.lastProfileMenuCommand = lastProfileMenuCommand;
    }

    public void setLastMainMenuCommand(MainMenuCommand lastMainMenuCommand) {
        this.lastMainMenuCommand = lastMainMenuCommand;
    }

    public void setLastLoginCommand(LoginCommand lastLoginCommand) {
        this.lastLoginCommand = lastLoginCommand;
    }

    public void setLastMajorLoginCommand(MajorLoginCommand lastMajorLoginCommand) {
        this.lastMajorLoginCommand = lastMajorLoginCommand;
    }

    public void setLastSignUpCommand(SignUpCommand lastSignUpCommand) {
        this.lastSignUpCommand = lastSignUpCommand;
    }
}