package jsonclass;

import com.gilecode.yagson.YaGson;
import model.*;

import java.io.FileReader;
import java.io.FileWriter;

public class GetAndSetJSON {
    private static GetAndSetJSON instance = new GetAndSetJSON();
    private GetAndSetJSON(){

    }
    public void getJson() {
        try {
            YaGson yaGson = new YaGson();
            yaGson.fromJson(new FileReader("json/plant.json"), Plant[].class);
            System.out.println(Plant.getPlants().size());
            yaGson.fromJson(new FileReader("json/zombie.json"), Zombie[].class);
            System.out.println(Zombie.getZombies().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setJson() {
        MakePlantAndZombie.getInstance().make();
        try {
            FileWriter fileWriter1 = new FileWriter("json/zombie.json");
            YaGson gson = new YaGson();

            String z = gson.toJson(Zombie.getZombies());
            fileWriter1.write(z);
            fileWriter1.flush();

            FileWriter fileWriter = new FileWriter("json/plant.json");
            String p = gson.toJson(Plant.getPlants());
            fileWriter.write(p);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static GetAndSetJSON getInstance() {
        return instance;
    }
}
