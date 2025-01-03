package Models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private int id;
    private PlayerType playerType;
    private Scanner scanner;

    //TODO :add method to make move



    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public Player(String name, char symbol, int id, PlayerType playerType,Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.id = id;
        this.playerType = playerType;
        this.scanner = scanner;
    }

    private boolean cellAvailable(Board board) {
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
                    return true;
                }
            }
        }
        return false;

    }

    public Move makeMove(Board board){
        System.out.println("Enter row and column");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if(!cellAvailable(board)){
            return null;
        }

        Cell cell = new Cell(row,col);

        System.out.printf("The player %s is making a move at cell: %d, %d\n",
                this.name, cell.getRow(), cell.getCol());
        if (cell.getCellStatus().equals(CellStatus.OCCUPIED)) {
            throw new IllegalArgumentException("The cell is occupied.");
        }

        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.OCCUPIED);
        return new Move(cell);
    }
}
