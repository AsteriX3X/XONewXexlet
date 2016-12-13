package ua.com.asterix.xo.view;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.gamers.Gamer;

public class ConsoleView implements IView {
    private Field field;
    private Gamer gamer;

    private void printLine(int amount) {
        for (int i = 0; i < amount * 6; i++) {
            System.out.print("~");
        }
    }

    private void showLine(Field field, int y) {
        for (int x = 0; x < Field.FIELD_SIZE; x++) {
            System.out.print(field.getFieldOfFigures()[x][y] + " ");
            System.out.print(x < 2 ? "| " : "  ");
        }
    }

    public void showGameName(String gameName) {
        System.out.printf("Добро пожаловать в %s", gameName);
    }

    @Override
    public void getGameType() {

    }

    @Override
    public void showRules() {

    }

    @Override
    public void showField(Field field) {

    }

    @Override
    public void getShoot() {

    }

    @Override
    public void showInvalidPoint() {

    }

    @Override
    public void showPointOccupied() {
        System.out.println("Уже занято, выберите другое поле");
    }

    @Override
    public void showWinner(String winnerName) {
        System.out.printf("Победил игрок %s", winnerName);
    }

    @Override
    public void showGameOver() {
        System.out.printf("Победила дружба");
    }

}
