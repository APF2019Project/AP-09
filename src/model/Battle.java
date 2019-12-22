package model;

import model.New_Zombies.Zombie;
import model.New_Plants.Plant;
import model.card.Card;

import static constants.Constants.MAP_COLUMNS_COUNT;

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

    public boolean checkSelectedCellForSpace(Cell selectedCell) {
        if (selectedCell.getPlant() != null)
            return false;
        return true;
    }

    public void zombieMoveAndAction() {
        for (Cell[] cells : map.getCells()) {
            for (Cell c : cells) {
                for (Zombie z : c.getZombies()){
                    z.move();//moves, then does it's action
                }
            }
        }
    }

    public Cell closestZombie(Cell cell) {
        int row = cell.getRow();
        Map gameMap = Battle.getRunningBattle().getMap();
        for (int i = MAP_COLUMNS_COUNT - 1; i >= 0; --i) {
            Cell checkCell = gameMap.getCell(row, i);
            if (cell.getColumn() < i)
                continue;
            else if (findZombie(checkCell)) {
                return checkCell;
            }
        }
        return null;
    }

    public boolean findZombie(Cell cell) {
        if (cell.getZombies() != null)
            return true;
        return false;
    }

    public void plantAttacks() {
        for (Cell[] cells : map.getCells()) {
            for (Cell c : cells) {
                if (c.getPlant() != null) {
                    //TODO plant in cell c attack it's closest zombie(using method closest Zombie)
                }
            }
        }
    }

    public boolean checkSelectedCellIsValidForInsert(Plant plant, Cell selectedCell) {
        if (checkSelectedCellForSpace(selectedCell)) {
            if (selectedCell.isLand() && plant.getPlantType() == PlantType.LAND)
                return true;
            else if (selectedCell.isLeaf() && plant.getPlantType() == PlantType.LAND) {
                return true;
            } else if (!selectedCell.isLand() && plant.getPlantType() == PlantType.WATER) {
                return true;
            } else if (!selectedCell.isLand() && plant.isLilyPad() && !selectedCell.isLeaf()) {
                return true;
            }
        }
        return false;
    }

    private void setPlantInCell(Plant plant, Cell selectedCell) {
        if (checkSelectedCellIsValidForInsert(plant, selectedCell))
            if (!plant.isLilyPad())
                selectedCell.setPlant(plant);
            else
                selectedCell.setLeaf(true);
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
