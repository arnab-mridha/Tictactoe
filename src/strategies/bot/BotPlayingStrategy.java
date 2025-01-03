package strategies.bot;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    Move suggestMove(Board board);
    // TODO: implement by getting player and board

}
