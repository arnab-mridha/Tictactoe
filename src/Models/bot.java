package Models;

import strategies.bot.BotPlayingStrategy;
import strategies.bot.BotPlayingStrategyFactory;

import java.util.Scanner;

public class bot extends Player{

    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public bot(String name, char symbol, int id, PlayerType playerType,
               BotDifficultyLevel botDifficultyLevel,
               Scanner sc) {

        super(name, symbol, id, playerType,sc);
        this.botDifficultyLevel = botDifficultyLevel;
//        this.botPlayingStrategy = botPlayingStrategy;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    //TODO: Override makeMove() method here
    @Override
    public Move makeMove(Board board){
        Move move = botPlayingStrategy.suggestMove(board);
        // NPE Check
        if (move == null) {
            return null;
        }

        System.out.printf("the bot is making a move %d %d.\n", move.getCell().getRow(), move.getCell().getCol());

        move.getCell().setPlayer(this);
        move.getCell().setCellStatus(CellStatus.OCCUPIED);

        return move;
    }
}
