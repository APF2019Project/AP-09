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
        if (command.toLowerCase().equals("login")){
            String UserAndPass = scanner.nextLine() ;
            if (UserAndPass.matches("\\w+ \\w+")) {
                String[] words = UserAndPass.split(" ");
                LoginCommand loginCommand = LoginCommand.LOGIN;
                loginCommand.setName(words[0]);
                loginCommand.setPassword(words[1]);
                lastLoginCommand = loginCommand;
            }
            else
                System.out.println("invalid command");
      }
    }

    public LoginCommand getLastLoginCommand() {
        return lastLoginCommand;
    }

    public void setLastLoginCommand(LoginCommand lastLoginCommand) {
        this.lastLoginCommand = lastLoginCommand;
    }
}