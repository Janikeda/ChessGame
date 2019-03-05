package model;

import Game.Board;
import Game.Color;
import Game.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure {

    private static final int[][] posMoves = {{1, 1}, {1, 0}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};

    public King(Position currPosition, Color color) {
        this.currPosition = currPosition;
        this.color = color;
        this.type = Type.KING;
    }

    @Override
    public List<Position> possibleMoves(Board board, Position pos) {
        List<Position> possibleMoves = new ArrayList<>();

        for (int[] posMove : posMoves) {
            Position position = new Position(pos.getX() + posMove[0], pos.getY() + posMove[1]);
            if (board.isWithinBounds(position)) {
                if (board.getPiece(position) == null || isOpponent(board.getPiece(position))) {
                        possibleMoves.add(position);
                }
            }
        }
        return possibleMoves;
    }

    private boolean isSafe(Board board, Position pos) {
        if (board.getTurn() == 0) {
            for (Figure figure : board.getBlackPieces()) {
                if (figure != null && !figure.possibleMoves(board, figure.getCurrPosition()).contains(pos)) {
                    return false;
                }
            }
        } else {
            for (Figure figure : board.getWhitePieces()) {
                if (figure != null && !figure.possibleMoves(board, figure.getCurrPosition()).contains(pos)) {
                    return false;
                }
            }
        }
        return true;
    }
}
