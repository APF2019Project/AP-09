package model.battle;

import model.*;
import model.New_Zombies.Zombie;
import model.card.Card;

import java.util.ArrayList;

import static constants.Constants.MAP_COLUMNS_COUNT;
import static constants.Constants.MAP_ROWS_COUNT;

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
    private boolean isSelectedSpace;
    private Cell selectedCell;
    private Map map;


    public Battle(Player plants, Player zombies, GameMode gameMode) {
        this.plants = plants;
        this.zombies = zombies;
        this.gameMode = gameMode;
        Battle.runningBattle = this;
        this.battleComponents = new BattleComponents();
    }

    public static void zombieWins() {
        Battle battle = Battle.getRunningBattle();
        battle.setWinnerPlayer(battle.zombies);
        battle.setEndGame(true);
    }

    public static void lawnMowerActivated(Cell cell, Map gameMap) {
        for (int j = 0; j < MAP_COLUMNS_COUNT; ++j) {
            Cell c = gameMap.getCell(cell.getRow(), j);
            for (int z = 0; z < c.getZombies().size(); ++z) {
                GraveYard.getDeadZombies().add(c.getZombies().get(z));
                c.getZombies().remove(z);
                --z;
            }
        }
    }

    public boolean checkSelectedCellIsValidForInsert(Cell cell) {
        return cell.getPlant() == null && cell.getColumn() % 2 == 0;
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

    public void doAllAttacksInTurn() {
        //TODO
    }

    public void insertNextRandomZombie() {
        //TODO
    }

    public void getNextRandomCard() {
        //TODO
    }

    public void initGame() {
        //TODO
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

    public static void setRunningBattle(Battle runningBattle) {
        Battle.runningBattle = runningBattle;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
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

    public void nextTurn() {
        this.turn += 1;
    }

    public Player getZombies() {
        return zombies;
    }

    public void setZombies(Player zombies) {
        this.zombies = zombies;
    }

    public Player getPlants() {
        return plants;
    }

    public void setPlants(Player plants) {
        this.plants = plants;
    }

    public BattleComponents getBattleComponents() {
        return battleComponents;
    }
}
