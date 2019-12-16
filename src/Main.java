import controller.Controller;
import warriorJSON.GetAndSetWarriorJSON;

public class Main {
    public static void main(String[] args) {
//        TODO :if you need to change zombie or plant variable and update JSON , first update MakePlantAndZombie class
//        GetAndSetJSON.getInstance().setJson();
        GetAndSetWarriorJSON.getInstance().getJson();
        Controller.getInstance().main();
    }


}
