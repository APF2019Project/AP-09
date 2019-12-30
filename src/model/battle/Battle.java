package model.battle;


import com.rits.cloning.Cloner;
import model.*;

import model.New_Plants.Plant;
import model.battle.managers.*;
import model.card.Card;
import model.card.CardOfPlant;


import static model.constants.Constants.MAP_COLUMNS_COUNT;

public class Battle {
    private Player plants;
    private Player zombies;
    private Player currentPlayer;
    private Player winnerPlayer;
    private int turn;
    private boolean isDraw;
    private boolean isEndGame;
    private Card selectedCard;
    private GameMode gameMode;
    private static Battle runningBattle;
    private BattleComponents battleComponents;
    private GraveYard graveYard = new GraveYard();
    private boolean isSelectedSpace;
    private Cell selectedCell;
    private Map map;
    private int wavesCount;
    private BattleManager battleManager;


    public Battle(Player plants, Player zombies, GameMode gameMode, int wavesCount) {
        this.plants = plants;
        this.zombies = zombies;
        this.gameMode = gameMode;
        this.setBattleManager(gameMode);
        this.wavesCount = wavesCount;
        Battle.runningBattle = this;
        this.battleComponents = new BattleComponents();
    }

    private void setBattleManager(GameMode gameMode) {
        switch (gameMode) {
            case DAY:
                this.battleManager = new DayBattleManager();
            case WATER:
                this.battleManager = new WaterBattleManager();
            case RAIL:
                this.battleManager = new RailBattleManager();
            case ZOMBIE:
                this.battleManager = new ZombieBattleManager();
            case MULTIPLAYER:
                this.battleManager = new PvPBattleManager();
        }
    }

    public void nextTurnInit() {
        if (!this.isEndGame()) {
            this.battleManager.manage();
        } else {
            System.out.println("Player " + this.getWinnerPlayer().getAccount().getUserName() + " won!");
        }
    }


    public void increaseZombieMoney(Account account) {
        int numOfDeadPlants = graveYard.getDeadPlants().size();
        int prize = 10 * numOfDeadPlants;
        account.setMoney(account.getMoney() + prize);
    }

    public boolean checkSelectedCellForSpace(Cell selectedCell) {
        return selectedCell.getPlantInGame() == null;
    }


    public void lawnMowerActivated(Cell cell) {
        for (int j = 0; j < MAP_COLUMNS_COUNT; ++j) {
            Cell c = this.map.getCell(cell.getRow(), j);
            for (int z = 0; z < c.getZombies().size(); ++z) {
                this.graveYard.getDeadZombies().add(c.getZombies().get(z));
                Battle.getRunningBattle().getBattleComponents().removeZombieFromGame(c.getZombies().get(z));
                c.getZombies().remove(z);
                --z;
            }
        }
    }

    public void increasePlantsSun(int sunCount) {
        this.plants.increaseSun(sunCount);
    }


    public void insertZombie() {
        //TODO ZombieMode Game
    }

    public boolean checkSelectedCellIsValidForInsertPlant(Cell cell) {
        return cell.getPlantInGame() == null && cell.getColumn() % 2 == 0;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Cell getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(Cell selectedCell) {
        this.selectedCell = selectedCell;
    }

    public boolean isSelectedSpace() {
        return isSelectedSpace;
    }

    public void setSelectedSpace(boolean selectedSpace) {
        isSelectedSpace = selectedSpace;
    }

    public static Battle getRunningBattle() {
        return runningBattle;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public boolean isEndGame() {
        return isEndGame;
    }

    public void setEndGame(boolean endGame) {
        isEndGame = endGame;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getTurn() {
        return turn;
    }

    public void incrementTurn() {
        this.turn += 1;
    }

    public Player getZombies() {
        return zombies;
    }

    public Player getPlants() {
        return plants;
    }

    public BattleComponents getBattleComponents() {
        return battleComponents;
    }

    public int getWavesCount() {
        return wavesCount;
    }

    public void decrementWavesCount() {
        this.wavesCount -= 1;
    }

    public GraveYard getGraveYard() {
        return graveYard;
    }
}
