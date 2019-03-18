package model;

import game.Board;
import game.Color;
import game.Position;

import java.util.ArrayList;
import java.util.List;

/* Пешка */
public class Pawn extends Figure {

    public Pawn(Position currPosition, Color color) {
        this.currPosition = currPosition;
        this.color = color;
        this.type = Type.PAWN;
        this.image = (isWhite() ? "whitePawn.png" : "blackPawn.png");
    }

    @Override
    public List<Position> possibleMoves(Board board, Position pos) {
        List<Position> possibleMoves = new ArrayList<>();
        boolean color = super.isWhite();
        int dx = color ? -1 : 1;

        Position ahead = new Position(pos.getX() + dx, pos.getY());
        if (board.isWithinBounds(ahead)) {
            if (board.getPiece(ahead) == null) {
                possibleMoves.add(ahead);
                if (super.getCurrPosition().getX() == 6 && color) {
                    Position aheadsecond = new Position(pos.getX() + (dx - 1), pos.getY());
                    if (board.getPiece(aheadsecond) == null) {
                        possibleMoves.add(aheadsecond);
                    }
                } else if (super.getCurrPosition().getX() == 1 && !color) {
                    Position aheadsecond = new Position(pos.getX() + (dx + 1), pos.getY());
                    if (board.getPiece(aheadsecond) == null) {
                        possibleMoves.add(aheadsecond);
                    }
                }
            }

        }

        Position aheadLeft = new Position(pos.getX() + dx, pos.getY() - 1);
        if (board.isWithinBounds(aheadLeft)) {
            if (board.getPiece(aheadLeft) != null && isOpponent(board.getPiece(aheadLeft))) {
                possibleMoves.add(aheadLeft);
            }
        }

        Position aheadRight = new Position(pos.getX() + dx, pos.getY() + 1);
        if (board.isWithinBounds(aheadRight)) {
            if (board.getPiece(aheadRight) != null && isOpponent(board.getPiece(aheadRight))) {
                possibleMoves.add(aheadRight);
            }
        }
        return possibleMoves;
    }
}
