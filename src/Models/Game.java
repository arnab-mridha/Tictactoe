package Models;

import strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> Players;
    List<Move> Moves;
    Player nextPlayerTurn;
    GameState gameState;
    List<WinningStrategy> winningStrategies;
    int currentPlayerIndex;
    Player winner;

    private Game(Builder gamedata){
        this.board = new Board(gamedata.dimension);
        this.Players = gamedata.players;
        this.winningStrategies = gamedata.winningStrategies;
        this.Moves = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
    }

    public static Builder getbuilder(){
        return new Builder();
    }

    //TODO: add Builder design pattern

    public static class Builder{
        private List<Player> players;
        List<WinningStrategy> winningStrategies;
        int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }

    public Board getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getCurrentPlayer() {
        return Players.get(currentPlayerIndex);
    }

    public void addMove(Move move) {
        Moves.add(move);
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void updateBoard(Move move) {
        // Update the board with the move taken.
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // Updating the cell in the board with the move that player took.
        this.board.getBoard().get(row).set(col, move.getCell());
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner(){
        return this.winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void nextPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % Players.size();
    }


}
