import controller.Controller;
import model.Account;
import warriorJSON.GetAndSetWarriorJSON;
// import warriorJSON.GetAndSetWarriorJSON;

public class Main {
    public static void main(String[] args) {
     // GetAndSetWarriorJSON.getInstance().setJson();
      GetAndSetWarriorJSON.getInstance().getJson();
        Account.getJson();
        Controller.getInstance().main();
    }


}
