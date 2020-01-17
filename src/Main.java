import controller.Controller;
import model.Account;
import model.card.Card;
import model.card.CardOfPlant;
import model.card.CardOfZombie;
import warriorJSON.GetAndSetWarriorJSON;
// import warriorJSON.GetAndSetWarriorJSON;

public class Main {
    public static void main(String[] args) {
     // GetAndSetWarriorJSON.getInstance().setJson();
      GetAndSetWarriorJSON.getInstance().getJson();
        CardOfPlant.defineAllCards();
        CardOfZombie.defineAllCards();
        Card.getCards().addAll(CardOfPlant.getPlantCards());
        Card.getCards().addAll(CardOfZombie.getZombieCards());
        Account.getJson();
        Controller.getInstance().main();
    }


}
