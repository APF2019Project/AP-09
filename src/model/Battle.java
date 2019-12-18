package model;

import java.util.ArrayList;

public class Battle {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player currentPlayer;
    private Player winnerPlayer;
    private int turn;
    private boolean isDraw;
    private boolean isEndGame;
    private Card selectedCard;
    private GameMode gameMode;
    private static Battle runningBattle;
    private boolean isSelectedSpace;
    private Cell selectedCell;
    private Map map;

    public boolean checkSelectedCellForSpace() {
        //TODO
        return false;
    }
    public void zombieAttack(){
        for(Cell c : map.getCells()){
            if(c.hasPlant() && c.hasZombie()){
                //TODO
            }
        }
    }
    public Cell closestZombie(Cell cell) {
        for (Cell c : map.getCells()) {
            if (c.getRow() != cell.getRow())
                continue;
            if(findZombie(c)) {
                return c;
            }
        }
        return null;
    }

    public boolean findZombie(Cell cell){
       if(cell.hasZombie())
           return true;
       return false;
    }

    public void plantAttacks() {
        for (Cell c : map.getCells()) {
            if (c.hasPlant()) {
                c.getPlant().attack(closestZombie(c), c);
            }
        }
    }

    public boolean checkSelectedCellIsValidForInsert() {
        //TODO
        return false;
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

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }
}
