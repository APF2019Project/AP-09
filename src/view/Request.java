package view;

import model.Account;
import model.card.Card;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

import static javax.xml.ws.Endpoint.create;

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
    private boolean exit;
    private boolean help;
    private boolean isInvalidCommand = false;


    private Request() {
        menus.add(Menu.MAJOR_LOGIN);
    }

    public static Request getInstance() {
        return request;
    }

    public void getRequest() {
        String command = scanner.nextLine();
        if (command.toLowerCase().equals("exit")) {
            exit = true;
            return;
        }
        if (command.toLowerCase().equals("help")) {
            help = true;
            return;
        }
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
            case PROFILE:
                profile(command.toLowerCase());
                break;
            case COLLECTION:
                collection(command.toLowerCase());
            case SHOP:
                shop(command.toLowerCase());
                break;
            case MAIN:
                main(command.toLowerCase());
                break;
            case LEADER_BOARD:
                leaderBoard();
                break;
        }
    }

    private void leaderBoard() {
        //Output.getInstance().printLeaderBoard();
        //TODO need to fix leaderBoardPrint method
    }

    private void main(String command) {
        for (int i = 0; i < Patterns.mainPatterns.length; ++i) {
            Matcher matcher = Patterns.mainPatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfMain(i);
                return;
            }
        }
        isInvalidCommand = true;
    }

    private void setCommandOfMain(int i) {
        lastMainMenuCommand = MainMenuCommand.values()[i];
    }

    private void profile(String command) {
        for (int i = 0; i < Patterns.profilePatterns.length; ++i) {
            Matcher matcher = Patterns.profilePatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfProfile(matcher, i);
                return;
            }
        }
        isInvalidCommand = true;
    }

    private void setCommandOfProfile(Matcher matcher, int i) {
        if (i == 3) {
            lastProfileMenuCommand = ProfileMenuCommand.values()[i];
            lastProfileMenuCommand.setName(matcher.group(1));
        } else if (i == 4) {
            lastProfileMenuCommand = ProfileMenuCommand.values()[i];
        } else {
            lastProfileMenuCommand = ProfileMenuCommand.values()[i];
            lastProfileMenuCommand.setName(matcher.group(1));
            lastProfileMenuCommand.setPassword(matcher.group(2));
        }
        doProfileCommand(lastProfileMenuCommand);
    }

    private void doProfileCommand(ProfileMenuCommand command) {
        switch (command) {
            case CHANGE:
                change(command);
                break;
            case RENAME:
                rename(command);
                break;
            case DELETE:
                delete(command);
                break;
            case CREATE:
                create(command);
                break;
            case SHOW:
                show(command);
                break;
        }
    }

    private void show(ProfileMenuCommand command) {
        Output.getInstance().printCurrentUserName();
    }

    private void delete(ProfileMenuCommand command) {
        if(Account.getLoggedAccount().getUserName().equals(command.getName())){
            if(Account.getLoggedAccount().getPassWord().equals(command.getPassword())){
                Account.getAllAccount().remove(Account.getLoggedAccount());
                Account.setLoggedAccount(null);
                return;
            }
            Output.getInstance().invalidPassword();
            return;
        }
        Output.getInstance().invalidUsername();
    }

    private void create(ProfileMenuCommand command) {
        for(Account account : Account.getAllAccount()){
            if(account.getUserName().equals(command.getName())){
                Output.getInstance().invalidUsername();
                return;
            }
        }
        Account account = new Account(command.getName(), command.getPassword());
        Account.getAllAccount().add(account);
        Account.setLoggedAccount(account);
    }

    private void rename(ProfileMenuCommand command) {
        Account.getLoggedAccount().setUserName(command.getName());
    }

    private void change(ProfileMenuCommand command) {
        for(Account account : Account.getAllAccount()){
            if(account.getUserName().equals(command.getName())){
                if(account.getPassWord().equals(command.getPassword())){
                    Account.setLoggedAccount(account);
                    return;
                }
                Output.getInstance().invalidPassword();
                return;
            }
            Output.getInstance().invalidUsername();
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
        isInvalidCommand = true;
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
        doCollectionCommand(lastCollectionCommand);
    }

    private void doCollectionCommand(CollectionCommand command) {
        switch (command){
            case SHOW_COLLECTION:
                Output.getInstance().showCollection();
                break;
            case SELECT:
                selectCard(command);
                break;
            case REMOVE:
                removeCard(command);
                break;
            case SHOW_HAND:
                Output.getInstance().showHand();
                break;
            case PLAY:
                break;
        }
    }

    private void removeCard(CollectionCommand command) {
        String name = command.getName();
        for(Card card : Account.getLoggedAccount().getDeck()){
            if(card.getCardName().equals(name)){
                Account.getLoggedAccount().getDeck().remove(card);
                return;
            }
        }
        Output.getInstance().invalidCard();
    }

    private void selectCard(CollectionCommand command) {
        String name = command.getName();
        for(Card card : Account.getLoggedAccount().getAllCard()){
            if(card.getCardName().equals(name)){
                if(Account.getLoggedAccount().getDeck().size() < 7) {
                    Account.getLoggedAccount().getDeck().add(card);
                    return;
                }
                Output.getInstance().cannotSelectMoreCards();
                return;
            }
        }
        Output.getInstance().invalidCard();
    }

    public void shop(String command) {
        for (int i = 0; i < Patterns.shopPatterns.length; i++) {
            Matcher matcher = Patterns.shopPatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfShop(matcher, i);
                return;
            }
        }
        isInvalidCommand = true;
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
            doSignUpCommand(lastSignUpCommand);
        } else
            isInvalidCommand = true;
    }

    private void doSignUpCommand(SignUpCommand command) {
        for(Account account : Account.getAllAccount()){
            if(account.getUserName().equals(command.getName())){
                Output.getInstance().invalidUsername();
                return;
            }
        }
        Account account = new Account(command.getName(), command.getPassword());
        Account.getAllAccount().add(account);
        Account.setLoggedAccount(account);
    }

    public void login(String command) {
        Matcher matcher = Patterns.loginPattern[0].matcher(command);
        if (matcher.matches()) {
            lastLoginCommand = LoginCommand.USERNAME_PASSWORD;
            lastLoginCommand.setName(matcher.group(0));
            lastLoginCommand.setPassword(matcher.group(1));
            doLoginCommand(lastLoginCommand);
        } else
            isInvalidCommand = true;
    }

    private void doLoginCommand(LoginCommand command) {
        for(Account account : Account.getAllAccount()){
            if(account.getUserName().equals(command.getName())){
                if(account.getPassWord().equals(command.getPassword())){
                    Account.setLoggedAccount(account);
                    return;
                }
                Output.getInstance().invalidPassword();
                return;
            }
            Output.getInstance().invalidUsername();
        }
    }


    public void majorLogin(String command) {
        for (int i = 0; i < Patterns.majorLoginPatterns.length; i++) {
            Matcher matcher = Patterns.majorLoginPatterns[i].matcher(command);
            if (matcher.matches()) {
                setCommandOfMajorLogin(i);
                return;
            }
        }
        isInvalidCommand = true;
    }

    public SignUpCommand getLastSignUpCommand() {
        return lastSignUpCommand;
    }

    public void setCommandOfMajorLogin(int i) {
        lastMajorLoginCommand = MajorLoginCommand.values()[i];
        System.out.println(lastMajorLoginCommand);
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

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isInvalidCommand() {
        return isInvalidCommand;
    }

    public void setInvalidCommand(boolean invalidCommand) {
        isInvalidCommand = invalidCommand;
    }
}