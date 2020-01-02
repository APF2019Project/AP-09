import controller.Controller;
import model.Account;
// import warriorJSON.GetAndSetWarriorJSON;

public class Main {
    public static void main(String[] args) {
//        TODO :if you need to change zombie or plant variable and update JSON , first update MakePlantAndZombie class
//        GetAndSetJSON.getInstance().setJson();
//        GetAndSetWarriorJSON.getInstance().getJson();
        Account.getJson();
        Controller.getInstance().main();
    }


}
