package Models;

public class Move {

    int moveNumber;

    Cell cell;

    public Move(Cell cell) {
        this.cell = cell;
    }

    public Move(int moveNumber, Cell cell) {
        this.moveNumber = moveNumber;
        this.cell = cell;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
