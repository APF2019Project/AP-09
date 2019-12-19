package warriorJSON;

import com.gilecode.yagson.YaGson;

import java.io.FileReader;
import java.io.FileWriter;

public class GetAndSetWarriorJSON {
    private static GetAndSetWarriorJSON instance = new GetAndSetWarriorJSON();
    private GetAndSetWarriorJSON(){

    }
    public void getJson() {
        try {
            YaGson yaGson = new YaGson();
            yaGson.fromJson(new FileReader("json/plant.json"), Plant1[].class);
            System.out.println(Plant1.getPlant1s().size());
            yaGson.fromJson(new FileReader("json/zombie.json"), Zombie1[].class);
            System.out.println(Zombie1.getZombies().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJson() {
        MakePlantAndZombie.getInstance().make();
        try {
            FileWriter fileWriter1 = new FileWriter("json/zombie.json");
            YaGson gson = new YaGson();
            String z = gson.toJson(Zombie1.getZombies());
            fileWriter1.write(z);
            fileWriter1.flush();

            FileWriter fileWriter = new FileWriter("json/plant.json");
            String p = gson.toJson(Plant1.getPlant1s());
            fileWriter.write(p);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GetAndSetWarriorJSON getInstance() {
        return instance;
    }
}