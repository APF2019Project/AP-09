package warriorJSON;

import com.gilecode.yagson.YaGson;
import model.New_Plants.Plant;
import model.New_Zombies.Zombie;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class GetAndSetWarriorJSON {
    private static GetAndSetWarriorJSON instance = new GetAndSetWarriorJSON();

    private GetAndSetWarriorJSON() {

    }

    public void getJson() {
        try {
            YaGson yaGson = new YaGson();
            Plant[] plants = yaGson.fromJson(new FileReader("json/plant.json"), Plant[].class);
            System.out.println(plants.length);
            Plant.setPlants(new ArrayList<>(Arrays.asList(plants)));
            Zombie[] zombies = yaGson.fromJson(new FileReader("json/zombie.json"), Zombie[].class);
            Zombie.setZombies(new ArrayList<>(Arrays.asList(zombies)));
            System.out.println(zombies.length);
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

    public static GetAndSetWarriorJSON getInstance() {
        return instance;
    }
}