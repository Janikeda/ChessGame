package game.web;

import game.Board;
import game.Color;
import game.Position;
import model.Figure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static game.Board.SIZE;

@Controller
public class ChessRestController {

    private Board board;
    private String msgForGameOver;
    private Color color;

    public ChessRestController() {
        this.board = new Board();
        this.msgForGameOver = null;
        this.color = Color.WHITE;
    }

    @GetMapping("/")
    public ModelAndView pageRender(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");

        Figure[][] boardArray = board.getBoardArray();

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (boardArray[row][column] == null) {
                    model.addAttribute("figure" + row + column, null);
                } else {
                    model.addAttribute("figure" + row + column, boardArray[row][column]);
                }
            }
        }
        return modelAndView;
    }

    @PostMapping("/makeMoveAction")
    public ModelAndView makeMove(RedirectAttributes redirectAttributes) {
        if (!board.isEnd()) {
            List<Position> posFigureMoves = new ArrayList<>();
            Figure figure = null;

            while (posFigureMoves.isEmpty()) {
                figure = board.getRandomFigure(color);
                posFigureMoves = figure.possibleMoves(board, figure.getCurrPosition());
            }

            Position positionTo = posFigureMoves.get(new Random().nextInt(posFigureMoves.size()));
            msgForGameOver = board.move(figure, positionTo);

            changeTurn();
        } else {
            redirectAttributes.addFlashAttribute("message", msgForGameOver + ". Нажмите 'Start New Game'");
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/clearResults")
    public ModelAndView startGame() {
        board = new Board();
        return new ModelAndView("redirect:/");
    }

    private void changeTurn() {
        if (color.equals(Color.WHITE)) {
            color = Color.BLACK;
        } else color = Color.WHITE;
    }
}
