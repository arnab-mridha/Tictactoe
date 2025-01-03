import Models.*;
import controllers.GameController;
import strategies.winningstrategies.ColWinningStrategy;
import strategies.winningstrategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Models.PlayerType.Bot;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameController gameController = new GameController();
        System.out.println("lets begin");

        System.out.println("Give dimension");

        int dimension = sc.nextInt();


        System.out.println("no of players");

        int numberOfPlayers = sc.nextInt();

        System.out.println("Is there a bot? y/n");

        String isBot = sc.next();

        int nonBotPlayers = numberOfPlayers;
        if (isBot.equals("y")) {
            nonBotPlayers -= 1;
        }

        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < nonBotPlayers; i++) {
            System.out.println("Enter the name of the player " + i);
            String playerName = sc.next();
            System.out.println("Enter the symbol for the player ");
            String symbol = sc.next();

            playerList.add(
                    new Player(playerName, symbol.charAt(0),
                            i, PlayerType.Human, sc));
        }

        if (isBot.equals("y")) {
            System.out.println("Enter the name of the bot ");
            String playerName = sc.next();
            System.out.println("Enter the symbol for the bot ");
            String symbol = sc.next();

            playerList.add(
                    new bot(playerName, symbol.charAt(0),
                            nonBotPlayers,PlayerType.Bot,
                            BotDifficultyLevel.EASY, sc));
        }

        Game game = GameController.createGame(dimension,playerList);

        while (gameController.getGameStatus(game).equals(GameState.IN_PROGRESS)){
            System.out.println("This is the current board ");
            gameController.displayBoard(game);
            //TODO undo
            gameController.executeNextMove(game);
        }
        System.out.println("Resule of the game ");

        if (gameController.getGameStatus(game).equals(GameState.DRAW)){
            System.out.println("DRAW");
        } else{
            System.out.println("Winner is "+ gameController.getWinner(game));
        }






//        Player bot = new bot("Bot",'O',1, PlayerType.Bot, BotDifficultyLevel.EASY,sc);
//        Player myself = new Player("Me",'X',1, PlayerType.Human,sc);
//
//        Game game = Game.getbuilder().
//                addPlayer(bot).
//                addPlayer(myself).
//                addWinningStrategy(new ColWinningStrategy()).
//                addWinningStrategy(new RowWinningStrategy()).
//                setDimension(3).
//                build();
//
//        game.makeMove();
//        game.makeMove();
    }
}