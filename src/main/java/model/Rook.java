package model;

import Game.Board;
import Game.Color;
import Game.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Ладья */
public class Rook extends Figure {

    public Rook(Position currPosition, Color color) {
        this.currPosition = currPosition;
        this.color = color;
        this.type = Type.ROOK;
    }

    @Override
    public List<Position> possibleMoves(Board board, Position pos) {
        List<Position> possibleMoves = new ArrayList<>();
        int row = pos.getX();
        int column = pos.getY();

        for (int i = row + 1; i < Board.SIZE; i++) {
            Position position = new Position(i, column);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }

        for (int i = row - 1; i > -1; i--) {
            Position position = new Position(i, column);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }

        for (int i = column + 1; i < Board.SIZE; i++) {
            Position position = new Position(row, i);
            if (board.getPiece(position) == null) {
                possibleMoves.add(position);
            } else if (isOpponent(board.getPiece(position))) {
                possibleMoves.add(position);
                break;
            } else {
                break;
            }
        }

        for (int i = column - 1; i > -1; i--) {
            Position position = new Position(row, i);
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
