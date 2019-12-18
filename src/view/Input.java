package view;

import command.LoginCommand;
import command.MainMenuCommand;
import controller.Controller;

import java.util.Scanner;


public class Input {
    private static Input instance = new Input();
    private Scanner scanner = new Scanner(System.in);
    private LoginCommand lastLoginCommand;
    private MainMenuCommand lastMainMenuCommand ;
    private Input(){

    }

    public void getCommandFromUserInConsole(){
        identifyCommand(scanner.nextLine());
    }

    public static Input getInstance() {
        return instance;
    }
    private void identifyCommand(String command){

        switch (Controller.getInstance().getCurrentMenu()){
            case MAJORLOGIN:
                login(command);
                break;
            case MAIN:
                main(command) ;
        }
    }

    private void main(String command) {
        if (command.toLowerCase().equals("profile")){
            lastMainMenuCommand = MainMenuCommand.PROFILE ;
        }
    }

    private void login(String command){
        if (command.toLowerCase().equals("login")){
            String UserAndPass = scanner.nextLine() ;
            if (UserAndPass.matches("\\w+ \\w+")) {
                String[] words = UserAndPass.split(" ");
                LoginCommand loginCommand = LoginCommand.LOGIN;
                loginCommand.setName(words[0]);
                loginCommand.setPassword(words[1]);
                lastLoginCommand = loginCommand;
            }

      }else if (command.toLowerCase().equals("sign up")){
            String UserAndPass = scanner.nextLine() ;
            if (UserAndPass.matches("\\w+ \\w+")) {
                String[] words = UserAndPass.split(" ");
                LoginCommand loginCommand = LoginCommand.SIGN_UP;
                loginCommand.setName(words[0]);
                loginCommand.setPassword(words[1]);
                lastLoginCommand = loginCommand;
            }
        }else if (command.toLowerCase().equals("leader board")){
            lastLoginCommand = LoginCommand.LEADERBOARD ;
        }else if (command.toLowerCase().equals("exit")){
            lastLoginCommand = LoginCommand.EXIT ;
        }
        else
            System.out.println("invalid command");
    }

    public LoginCommand getLastLoginCommand() {
        return lastLoginCommand;
    }

    public void setLastLoginCommand(LoginCommand lastLoginCommand) {
        this.lastLoginCommand = lastLoginCommand;
    }

    public MainMenuCommand getLastMainMenuCommand() {
        return lastMainMenuCommand;
    }

    public void setLastMainMenuCommand(MainMenuCommand lastMainMenuCommand) {
        this.lastMainMenuCommand = lastMainMenuCommand;
    }
}