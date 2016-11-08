package ua.com.asterix.xo.view;

import ua.com.asterix.xo.model.Field;

public class ConsoleView implements IView {
    public Field field = new Field();

    @Override
    public void showField() {
        for (int y = 0; y < Field.FIELD_SIZE_Y; y++) {
            showLine(field, y);
            System.out.println();

            if (y < 2) {
                printLine(Field.FIELD_SIZE_Y);
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
        for (int x = 0; x < Field.FIELD_SIZE_X; x++) {
            System.out.print(field.getFieldOfFigures()[x][y] + " ");
            System.out.print(x < 2 ? "| " : "  ");
        }
    }

    @Override
    public void showPointOccupied() {

    }

    @Override
    public void showGameName() {

    }

    @Override
    public void showWinner() {

    }

    @Override
    public void showGameOver() {
        System.out.println("Победил");
    }
}
