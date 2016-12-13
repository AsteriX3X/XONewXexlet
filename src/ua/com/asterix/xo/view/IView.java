package ua.com.asterix.xo.view;

import ua.com.asterix.xo.model.Field;

public interface IView {
    String gameType = "Выберите тип игры (1, 2, 3) или 4 для выхода: ";
    String invalidPoint = "Не верные координаты точки";
    String alreadyOccupied = "Уже занято, выберите другое поле";
    String winnerName = "Победил игрок %s";
    String noWinner = "Победила дружба";

    void getGameType();

    void showRules();

    void showField(Field field);

    void getShoot();

    void showInvalidPoint();

    void showPointOccupied();

    void showWinner(String winnerName);

    void showGameOver();

}
