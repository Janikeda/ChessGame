package Game;

import model.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public void gameSession() {
        Board gameBoard = new Board();

        while (!gameBoard.isEnd()) {
            List<Position> posFigureMoves = new ArrayList<>();
            Figure figure = null;

            while (posFigureMoves.isEmpty()) {
                figure = gameBoard.getRandomFigure();
                posFigureMoves = figure.possibleMoves(gameBoard,figure.getCurrPosition());
            }

            Position positionTo = posFigureMoves.get(new Random().nextInt(posFigureMoves.size()));

            gameBoard.move(figure, positionTo);
        }
    }
}
