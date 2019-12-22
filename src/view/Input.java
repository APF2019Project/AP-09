package view;

import controller.Controller;

import java.util.Scanner;


public class Input {
    private static Input instance = new Input();
    private Scanner scanner = new Scanner(System.in);
    private boolean invalidCommand = false;
    private MajorLoginCommand lastMajorLoginCommand;
    private MainMenuCommand lastMainMenuCommand;
    private LeaderBoardCommand lastLeaderBoardCommand;
    private boolean exit = false;
    private boolean help = false;
    private Input() {

    }

    public void getCommandFromUserInConsole() {
        identifyCommand(scanner.nextLine());
    }

    public static Input getInstance() {
        return instance;
    }

    private void identifyCommand(String command) {
        if (command.toLowerCase().equals("exit")) {
            exit =true;
            return;
        }if (command.toLowerCase().equals("help")){
            help = true;
            return;
        }
        switch (Controller.getInstance().getCurrentMenu()) {
            case MAJOR_LOGIN:
                login(command);
                break;
            case MAIN:
                main(command);
                break;
            case LEADER_BOARD:
                leaderBoard(command);
                break;

        }
    }

    private void leaderBoard(String command) {
        if (command.toLowerCase().equals("exit")) {
            lastLeaderBoardCommand = LeaderBoardCommand.EXIT;
        } else invalidCommand();
    }

    private void main(String command) {
        if (command.toLowerCase().equals("profile")) {
            lastMainMenuCommand = MainMenuCommand.PROFILE;
        } else if (command.toLowerCase().equals("play")) {
            lastMainMenuCommand = MainMenuCommand.PLAY;
        } else if (command.toLowerCase().equals("shop")) {
            lastMainMenuCommand = MainMenuCommand.SHOP;
        } else {
            invalidCommand();
        }
    }

    private void login(String command) {
        if (command.toLowerCase().equals("login")) {
            String UserAndPass = scanner.nextLine();
            if (UserAndPass.matches("\\w+ \\w+")) {
                String[] words = UserAndPass.split(" ");
                MajorLoginCommand MajorLoginCommand = view.MajorLoginCommand.LOGIN;
                MajorLoginCommand.setName(words[0]);
                MajorLoginCommand.setPassword(words[1]);
                lastMajorLoginCommand = MajorLoginCommand;
            } else {
                invalidCommand();
            }

        } else if (command.toLowerCase().equals("sign up")) {
            String UserAndPass = scanner.nextLine();
            if (UserAndPass.matches("\\w+ \\w+")) {
                String[] words = UserAndPass.split(" ");
                MajorLoginCommand loginCommand = MajorLoginCommand.SIGN_UP;
                loginCommand.setName(words[0]);
                loginCommand.setPassword(words[1]);
                lastMajorLoginCommand = loginCommand;
            } else invalidCommand();
        } else if (command.toLowerCase().equals("leader board")) {
            lastMajorLoginCommand = MajorLoginCommand.LEADER_BOARD;
        } else if (command.toLowerCase().equals("endGame")) {
            lastMajorLoginCommand = MajorLoginCommand.EXIT;
        } else
            invalidCommand();
    }

    public void invalidCommand() {
        System.out.println("invalid view.command");
        invalidCommand = true;
    }

    public MajorLoginCommand getLastMajorLoginCommand() {
        return lastMajorLoginCommand;
    }

    public void setLastMajorLoginCommand(MajorLoginCommand lastMajorLoginCommand) {
        this.lastMajorLoginCommand = lastMajorLoginCommand;
    }

    public MainMenuCommand getLastMainMenuCommand() {
        return lastMainMenuCommand;
    }

    public void setLastMainMenuCommand(MainMenuCommand lastMainMenuCommand) {
        this.lastMainMenuCommand = lastMainMenuCommand;
    }

    public boolean isInvalidCommand() {
        return invalidCommand;
    }

    public void setInvalidCommand(boolean invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    public LeaderBoardCommand getLastLeaderBoardCommand() {
        return lastLeaderBoardCommand;
    }

    public void setLastLeaderBoardCommand(LeaderBoardCommand lastLeaderBoardCommand) {
        this.lastLeaderBoardCommand = lastLeaderBoardCommand;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }
}