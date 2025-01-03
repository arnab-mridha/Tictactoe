package strategies.bot;

import Models.Board;
import Models.CellStatus;
import Models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move suggestMove(Board board) {
        for (int i= 0; i<board.getBoard().size() ; i++){
            for (int j= 0; j<board.getBoard().size() ; j++){
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY) ){
                    return new Move(board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
