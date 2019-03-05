package model;

import Game.Board;
import Game.Color;
import Game.Position;

import java.util.List;

public abstract class Figure {
    protected Position currPosition;

    protected Color color;

    protected Type type;


    public abstract List<Position> possibleMoves(Board board, Position pos);

    public Position getCurrPosition() {
        return currPosition;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isOpponent(Figure figure) {
        return figure != null && isWhite() != figure.isWhite();
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}
