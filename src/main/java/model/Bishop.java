package model;

import Game.Board;
import Game.Color;
import Game.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Слон (офицер) */
public class Bishop extends Figure {

    public Bishop(Position currPosition, Color color) {
        this.currPosition = currPosition;
        this.color = color;
        this.type = Type.BISHOP;
    }

    @Override
    public List<Position> possibleMoves(Board board, Position pos) {
        List<Position> possibleMoves = new ArrayList<>();

        int row = pos.getX();
        int column = pos.getY();

        for (int j = column + 1, i = row + 1; j < Board.SIZE && i < Board.SIZE; j++, i++) {
            Position position = new Position(i, j);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }

        for (int j = column - 1, i = row + 1; j > -1 && i < Board.SIZE; j--, i++) {
            Position position = new Position(i, j);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }

        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
            Position position = new Position(i, j);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }

        for (int j = column + 1, i = row - 1; j < Board.SIZE && i > -1; j++, i--) {
            Position position = new Position(i, j);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }
        return possibleMoves;
    }
}
