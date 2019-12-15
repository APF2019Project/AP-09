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
        try {
            FileWriter fileWriter1 = new FileWriter("json/zombie.json");
            YaGson gson = new YaGson();

            for (int i = 0; i < 15; i++) {
                Zombie zombie = new Zombie();
                zombie.setZombieType(ZombieType.WATER);
                zombie.setTruckType(TruckType.STRONG);
                zombie.setHelmetType(HelmetType.BUCKETHEAD);
            }

            String z = gson.toJson(Zombie.getZombies());
            fileWriter1.write(z);
            fileWriter1.flush();
            FileWriter fileWriter = new FileWriter("json/plant.json");

            for (int i = 0; i < 24; i++) {
                Plant plant = new Plant();
                plant.setPlantType(PlantType.WATER);
                plant.setBombType(BombType.CHERRY);
                plant.setBulletType(BulletType.GATLINGPEA);
                plant.setNutType(NutType.EXPLODEONUT);
                plant.setSunflowerType(SunflowerType.SINGLE);
            }

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
