package model;

import Game.Board;
import Game.Color;
import Game.Position;

import java.util.List;

public class Queen extends Figure {
    private final Rook fakeRook;
    private final Bishop fakeBishop;


    public Queen(Position currPosition, Color color) {
        this.currPosition = currPosition;
        this.color = color;
        this.fakeBishop= new Bishop(currPosition, color);
        this.fakeRook = new Rook(currPosition, color);
        this.type = Type.QUEEN;
    }

    @Override
    public List<Position> possibleMoves(Board board, Position pos) {
        List<Position> result = fakeBishop.possibleMoves(board, pos);
        result.addAll(fakeRook.possibleMoves(board, pos));

        return result;
    }
}
