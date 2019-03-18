package model;

import game.Board;
import game.Color;
import game.Position;

import java.util.ArrayList;
import java.util.List;

/* Конь */
public class Knight extends Figure {

    private static final int[][] posMoves = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public Knight(Position currPosition, Color color) {
        this.currPosition = currPosition;
        this.color = color;
        this.type = Type.KNIGHT;
        this.image = (isWhite() ? "whiteKnight.png" : "blackKnight.png");
    }

    @Override
    public List<Position> possibleMoves(Board board, Position pos) {
        List<Position> possibleMoves = new ArrayList<>();

        for (int[] posMove : posMoves) {
            Position position = new Position(pos.getX() + posMove[0], pos.getY() + posMove[1]);
            if (board.isWithinBounds(position)) {
                if (position != null && (board.getPiece(position) == null || isOpponent(board.getPiece(position)))) {
                    possibleMoves.add(position);
                }
            }
        }
        return possibleMoves;
    }
}
