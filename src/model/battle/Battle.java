package model.battle;

import constants.Constants;
import model.*;

import model.New_Plants.*;
import model.New_Zombies.Zombie;
import model.battle.BattleComponents;
import model.battle.GraveYard;
import model.card.Card;

import static constants.Constants.MAP_COLUMNS_COUNT;

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


    public Battle(Player plants, Player zombies, GameMode gameMode, int wavesCount) {
        this.plants = plants;
        this.zombies = zombies;
        this.gameMode = gameMode;
        this.wavesCount = wavesCount;
        Battle.runningBattle = this;
        this.battleComponents = new BattleComponents();
    }
    public static void zombieWins() {
        Battle battle = Battle.getRunningBattle();
        battle.setWinnerPlayer(battle.zombies);
        if(battle.getCurrentPlayer().equals(battle.zombies)){
            Account account = Account.getLoggedAccount();
            battle.increaseZombieMoney(account);
        }
        battle.setEndGame(true);
    }

    public void initTurn() {
        if (!this.isEndGame()) {
            this.getBattleComponents().manage();
            this.checkForZombiesWin();
            this.checkForPlantsWin();
            this.nextTurn();
        } else {

        }
    }

    public void insertNextRandomZombie() {
        //TODO
    }


    public void increaseZombieMoney(Account account) {
        int numOfDeadPlants = graveYard.getDeadPlants().size();
        int prize = 10 * numOfDeadPlants;
        account.setMoney(account.getMoney() + prize);
    }

    public boolean checkSelectedCellForSpace(Cell selectedCell) {
        if (selectedCell.getPlant() != null)
            return false;
        return true;
    }

    public void zombieMoveAndAction() {
        for (Cell[] cells : map.getCells()) {
            for (Cell c : cells) {
                for (ZombieInGame z : c.getZombies()) {
                    z.action();//moves, then does it's action
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

//    public boolean checkSelectedCellIsValidForInsert(Plant plant, Cell selectedCell) {
//        if (checkSelectedCellForSpace(selectedCell)) {
//            if (selectedCell.isLand() && plant.getPlantKind() == PlantType.LAND)
//                return true;
//            else if (selectedCell.isLeaf() && plant.getPlantType() == PlantType.LAND) {
//                return true;
//            } else if (!selectedCell.isLand() && plant.getPlantType() == PlantType.WATER) {
//                return true;
//            } else if (!selectedCell.isLand() && plant.isLilyPad() && !selectedCell.isLeaf()) {
//                return true;
//            }
//        }
//        return false;
//    }

//    private void setPlantInCell(Plant plant, Cell selectedCell) {
//        if (checkSelectedCellIsValidForInsert(plant, selectedCell))
//            if (!plant.isLilyPad())
//                selectedCell.setPlant(plant);
//            else
//                selectedCell.setLeaf(true);
//    }

    public void checkForZombiesWin() {

        for (int i = 0; i < Constants.MAP_ROWS_COUNT; i++) {
            Cell cell = Battle.getRunningBattle().getMap().getCell(i, 0);
            if (cell.getZombies().size() >= 1 && !this.map.getLawnMower()[cell.getRow()]) {
                this.setWinnerPlayer(this.zombies);
                this.setEndGame(true);
                increaseZombieMoney(this.zombies.getAccount());
            }
        }
    }

    public void checkForPlantsWin() {
        if (this.wavesCount == 0) {
            this.setWinnerPlayer(this.plants);
            this.setEndGame(true);
        }
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

    public void nextTurn() {
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

    public GraveYard getGraveYard() {
        return graveYard;
    }
}
