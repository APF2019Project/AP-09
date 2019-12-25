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
    private ProfileMenuCommand lastProfileMenuCommand;
    private CollectionCommand lastCollectionCommand;
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
            exit = true;
            return;
        }
        if (command.toLowerCase().equals("help")) {
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
            case PROFILE:
                profile(command);
                break;
            case COLLECTION:
                collection(command);
                break;

        }
    }

    private void collection(String command) {
        if(command.toLowerCase().equals("show hand")){
            lastCollectionCommand = CollectionCommand.SHOW_HAND;
        }
        else if(command.toLowerCase().equals("show collection")){
            lastCollectionCommand = CollectionCommand.SHOW_COLLECTION;
        }
        else if(command.toLowerCase().equals("play")){
            lastCollectionCommand = CollectionCommand.PLAY;
        }
        else if(command.toLowerCase().equals("select")){
            String name = scanner.nextLine();
            if(name.matches("\\w+")){
                lastCollectionCommand = CollectionCommand.SELECT;
                lastCollectionCommand.setName(name);
            }
        }
        else if(command.toLowerCase().equals("remove")){
            String name = scanner.nextLine();
            if(name.matches("\\w+")){
                lastCollectionCommand = CollectionCommand.REMOVE;
                lastCollectionCommand.setName(name);
            }
        }
        else
            invalidCommand();
    }

    public void profile(String command) {
        if (command.toLowerCase().equals("change")) {
            String userAndPass = scanner.nextLine();
            if (userAndPass.matches("\\w+ \\w+")) {
                String[] words = userAndPass.split(" ");
                lastProfileMenuCommand = ProfileMenuCommand.CHANGE;
                lastProfileMenuCommand.setName(words[0]);
                lastProfileMenuCommand.setPassword(words[1]);
            }

        }
        if(command.toLowerCase().equals("show")){
            ProfileMenuCommand profileMenuCommand = ProfileMenuCommand.SHOW;
            lastProfileMenuCommand = profileMenuCommand;
        }
        if(command.toLowerCase().equals("create")){
            String userAndPass = scanner.nextLine();
            if (userAndPass.matches("\\w+ \\w+")) {
                String[] words = userAndPass.split(" ");
                ProfileMenuCommand profileMenuCommand = ProfileMenuCommand.CREATE;
                profileMenuCommand.setName(words[0]);
                profileMenuCommand.setPassword(words[1]);
                lastProfileMenuCommand = profileMenuCommand;
            }
        }
        if(command.toLowerCase().equals("delete")){
            String userAndPass = scanner.nextLine();
            if (userAndPass.matches("\\w+ \\w+")) {
                String[] words = userAndPass.split(" ");
                ProfileMenuCommand profileMenuCommand = ProfileMenuCommand.DELETE;
                profileMenuCommand.setName(words[0]);
                profileMenuCommand.setPassword(words[1]);
                lastProfileMenuCommand = profileMenuCommand;
            }
        }
        if(command.toLowerCase().equals("rename")){
            String username = scanner.nextLine();
            if (username.matches("\\w+")) {
                ProfileMenuCommand profileMenuCommand = ProfileMenuCommand.RENAME;
                profileMenuCommand.setName(username);
                lastProfileMenuCommand = profileMenuCommand;
            }
        }
        else
            invalidCommand();
    }

    public void leaderBoard(String command) {
        if (command.toLowerCase().equals("exit")) {
            lastLeaderBoardCommand = LeaderBoardCommand.EXIT;
        } else invalidCommand();
    }

    public void main(String command) {
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

    public void login(String command) {
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

    public ProfileMenuCommand getLastProfileMenuCommand() {
        return lastProfileMenuCommand;
    }

    public void setLastProfileMenuCommand(ProfileMenuCommand lastProfileMenuCommand) {
        this.lastProfileMenuCommand = lastProfileMenuCommand;
    }

    public CollectionCommand getLastCollectionCommand() {
        return lastCollectionCommand;
    }

    public void setLastCollectionCommand(CollectionCommand lastCollectionCommand) {
        this.lastCollectionCommand = lastCollectionCommand;
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