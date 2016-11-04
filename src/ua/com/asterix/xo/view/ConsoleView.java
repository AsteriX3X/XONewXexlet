package ua.com.asterix.xo.view;

import ua.com.asterix.xo.controller.GameController;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Point;

public class ConsoleView implements IView{

    public void showField() {
        for (int y = 0; y < Field.getFieldSize(); y++) {
            showLine(game.getField(), y);
            System.out.println();

            if (y < 2) {
                printLine(Field.getFieldSize());
                System.out.println();
            }
        }
    }

    private void printLine(int amount) {
        for (int i = 0; i < amount * 6; i++) {
            System.out.print("~");
        }
    }

    private void showLine(Field field, int y) {
        for (int x = 0; x < Field.getFieldSize(); x++) {
            System.out.print(field.getFieldOfFigures()[x][y] + " ");
            System.out.print(x < 2 ? "| " : "  ");
        }
    }

    @Override
    public Point startTurn() {
        return null;
    }

    @Override
    public void showGameName() {

    }

    @Override
    public void showPlayers() {

    }

    @Override
    public void showWinner() {

    }

    @Override
    public void showDraw() {

    }

    @Override
    public void anotherGame() {

    }

    @Override
    public void showPointOccupied() {

    }

    @Override
    public GameController getGameController() {
        return null;
    }
}
