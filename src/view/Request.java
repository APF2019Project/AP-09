package view;

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
    private LeaderBoardCommand lastLeaderBoardCommand;

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

    public LeaderBoardCommand getLastLeaderBoardCommand() {
        return lastLeaderBoardCommand;
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
            case LEADER_BOARD:
                leaderBoard(command.toLowerCase());
                break;

        }
    }

    public void leaderBoard(String command) {
        Matcher matcher = Patterns.loginPattern.matcher(command);
        if(matcher.matches()){

        }
    }

    public void signUp(String command) {
        Matcher matcher = Patterns.loginPattern.matcher(command);
        if (matcher.matches()) {
            SignUpCommand signUpCommand = SignUpCommand.USERNAME_PASSWORD;
            signUpCommand.setName(matcher.group(1));
            signUpCommand.setPassword(matcher.group(2));
        }
        // TODO error
    }

    public void login(String command) {
        Matcher matcher = Patterns.loginPattern.matcher(command);
        if (matcher.matches()) {
            LoginCommand loginCommand = LoginCommand.USERNAME_PASSWORD;
            loginCommand.setName(matcher.group(0));
            loginCommand.setPassword(matcher.group(1));
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
}