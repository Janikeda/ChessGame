package model;

import game.Board;
import game.Color;
import game.Position;

import java.util.List;

public abstract class Figure {
    protected Position currPosition;

    protected Color color;

    protected Type type;

    protected String image;


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

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}
