package view;

import command.LoginCommand;
import controller.Controller;

import java.util.Scanner;


public class Input {
    private static Input instance = new Input();
    private Scanner scanner = new Scanner(System.in);
    private LoginCommand lastLoginCommand;
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
            case LOGIN:
                login(command);
                break;

        }
    }

    private void login(String command){
//        if (command.equals("login")){
            LoginCommand loginCommand = LoginCommand.LOGIN;
            loginCommand.setName();
            loginCommand.setPassword();
            lastLoginCommand = loginCommand;
//        }
    }

    public LoginCommand getLastLoginCommand() {
        return lastLoginCommand;
    }

    public void setLastLoginCommand(LoginCommand lastLoginCommand) {
        this.lastLoginCommand = lastLoginCommand;
    }
}