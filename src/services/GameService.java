package services;

import Models.Game;
import Models.GameState;
import Models.Move;
import Models.Player;
import strategies.winningstrategies.WinningStrategy;

public class GameService {
    Game game;

    public GameService(Game game){
        this.game = game;
    }

    public void executeNextMove(){
        Player currentPlayer = game.getCurrentPlayer();
        System.out.printf("Player turn : %s",currentPlayer.getName());

        Move move = currentPlayer.makeMove(game.getBoard());

        if (move == null) {
            game.setGameState(GameState.DRAW);
            return;
        }

        game.addMove(move);
        game.updateBoard(move);
        //update the board with the latest move

        for (WinningStrategy winningStrategy:game.getWinningStrategies()){
            if (winningStrategy.checkWinner(game.getBoard(),move)){
                System.out.printf("Player %s has own",currentPlayer.getName());
                game.setGameState(GameState.WIN);
                game.setWinner(currentPlayer);
                break;
            }
        }
        game.nextPlayerTurn();
    }
}
