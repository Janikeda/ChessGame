package game;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static game.Color.BLACK;
import static game.Color.WHITE;

public class Board {

    public static final int SIZE = 8;
    private Figure[][] boardArray;
    private List<Figure> whitePieces = new ArrayList<>(16);
    private List<Figure> blackPieces = new ArrayList<>(16);
    private boolean isEnd;

    public Board() {
        boardArray = new Figure[SIZE][SIZE];
        setPieces();
        System.out.println("Старт новой игры!");
    }

    public String move(Figure figure, Position to) {
        Position currentPosition = figure.getCurrPosition();

        int originX = currentPosition.getX();
        int originY = currentPosition.getY();

        currentPosition.setX(to.getX());
        currentPosition.setY(to.getY());

        Figure figureToDelete = getPiece(to);

        if (figureToDelete instanceof King) {
            isEnd = true;
            String msg = "Игра окончена. Король " + figureToDelete + " убит!" + " Последний ход сделала: " + figure;
            System.out.println(msg);
            return msg;
        } else {
            boardArray[currentPosition.getX()][currentPosition.getY()] = figure;
            boardArray[originX][originY] = null;

            if (figure.isWhite()) {
                blackPieces.remove(figureToDelete);
            } else {
                whitePieces.remove(figureToDelete);
            }

            System.out.println("Фигура " + figure + " сделала ход. " +
                    "Из клетки " + "x = " + originX + ", y = " + originY + ". На клетку " + "x = " + currentPosition.getX() + ", y = " + currentPosition.getY());

            if (figureToDelete != null) {
                System.out.println("Была убита фигура " + figureToDelete);
            }
            return "";
        }
    }

    public Figure getPiece(Position pos) {
        int x = pos.getX();
        int y = pos.getY();
        if (inSizeOfBoard(x) && inSizeOfBoard(y)) {
            return boardArray[x][y];
        } else
            return null;
    }

    public boolean inSizeOfBoard(int i) {
        return i >= 0 && i < SIZE;
    }

    private void setPieces() {
        setWhitePieces();
        setBlackPieces();
        setPieceList();
    }

    private void setBlackPieces() {
        for (int i = 0; i < 8; i++) {
            Figure pawn = new Pawn(new Position(1, i), BLACK);
            boardArray[1][i] = pawn;
        }

        boardArray[0][0] = new Rook(new Position(0, 0), BLACK);
        boardArray[0][7] = new Rook(new Position(0, 7), BLACK);

        boardArray[0][1] = new Knight(new Position(0, 1), BLACK);
        boardArray[0][6] = new Knight(new Position(0, 6), BLACK);

        boardArray[0][2] = new Bishop(new Position(0, 2), BLACK);
        boardArray[0][5] = new Bishop(new Position(0, 5), BLACK);

        boardArray[0][3] = new Queen(new Position(0, 3), BLACK);
        boardArray[0][4] = new King(new Position(0, 4), BLACK);
    }


    private void setWhitePieces() {
        for (int i = 0; i < 8; i++) {
            Figure pawn = new Pawn(new Position(6, i), WHITE);
            boardArray[6][i] = pawn;
        }

        boardArray[7][0] = new Rook(new Position(7, 0), WHITE);
        boardArray[7][7] = new Rook(new Position(7, 7), WHITE);

        boardArray[7][1] = new Knight(new Position(7, 1), WHITE);
        boardArray[7][6] = new Knight(new Position(7, 6), WHITE);

        boardArray[7][2] = new Bishop(new Position(7, 2), WHITE);
        boardArray[7][5] = new Bishop(new Position(7, 5), WHITE);

        boardArray[7][3] = new Queen(new Position(7, 3), WHITE);
        boardArray[7][4] = new King(new Position(7, 4), WHITE);
    }

    private void setPieceList() {
        for (int i = 0; i < 8; i++) {
            whitePieces.add(boardArray[6][i]);
            whitePieces.add(boardArray[7][i]);
            blackPieces.add(boardArray[0][i]);
            blackPieces.add(boardArray[1][i]);
        }
    }

    public Figure getRandomFigure(Color color) {
        Random random = new Random();
        if (color.equals(WHITE)) {
            return whitePieces.get(random.nextInt(whitePieces.size()));
        } else return blackPieces.get(random.nextInt(blackPieces.size()));
    }

    public boolean isEnd() {
        return isEnd;
    }

    public boolean isWithinBounds(Position position) {
        return (0 <= position.getX() && position.getX() < SIZE) && (0 <= position.getY() && position.getY() < SIZE);
    }

    public List<Figure> getWhitePieces() {
        return whitePieces;
    }

    public List<Figure> getBlackPieces() {
        return blackPieces;
    }

    public Figure[][] getBoardArray() {
        return boardArray;
    }
}
