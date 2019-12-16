import controller.Controller;
import jsonclass.GetAndSetJSON;

public class Main {
    public static void main(String[] args) {
//        TODO :if you need to change zombie or plant variable and update JSON , first update MakePlantAndZombie class
//        GetAndSetJSON.getInstance().setJson();
        GetAndSetJSON.getInstance().getJson();
        Controller.getInstance().main();
    }


}
