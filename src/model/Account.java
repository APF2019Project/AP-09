package model;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;
import model.card.Card;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Account implements Comparable<Account> {
    private static Account loggedAccount;
    private static ArrayList<Account> allAccount = new ArrayList<>();
    private String userName;
    private String passWord;
    private ArrayList<Card> allCard;
    private ArrayList<Card> deck;
    private int killedZombies;
    private int money;

    public Account(String userName, String passWord) {
        allAccount.add(this);
        this.userName = userName;
        this.passWord = passWord;
    }

    public static Account getLoggedAccount() {
        return loggedAccount;
    }

    public static void setLoggedAccount(Account loggedAccount) {
        Account.loggedAccount = loggedAccount;
    }

    public static ArrayList<Account> getAllAccount() {
        return allAccount;
    }

    public static void setAllAccount(ArrayList<Account> allAccount) {
        Account.allAccount = allAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ArrayList<Card> getAllCard() {
        return allCard;
    }


    public int getKilledZombies() {
        return killedZombies;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setKilledZombies(int killedZombies) {
        this.killedZombies = killedZombies;
    }

    public static void toJson() {
        FileWriter fileWriter1;
        try {
            fileWriter1 = new FileWriter("json/account.json");
            YaGson gson = new YaGson();
            String z = gson.toJson(Account.getAllAccount());
            fileWriter1.write(z);
            fileWriter1.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getJson() {
        YaGson yaGson = new YaGson();
        try {
            Account[] accounts = yaGson.fromJson(new FileReader("json/account.json"), Account[].class);
            if (accounts != null)
                for (int i = 0; i < accounts.length; i += 2) {
                    Account.getAllAccount().add(accounts[i]);
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void increaseMoney(int n) {
        this.money += n;
    }

    public void decreaseMoney(int n) {
        this.money -= n;
    }

    @Override
    public int compareTo(Account o) {
        return Integer.compare(o.killedZombies, this.killedZombies);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
