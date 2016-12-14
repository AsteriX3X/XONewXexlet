package ua.com.asterix.xo.view;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Point;
import ua.com.asterix.xo.model.gamers.Gamer;

public interface IView {
//    String gameType = "Выберите тип игры (1, 2, 3) или 4 для выхода: ";
//    String invalidPoint = "Не верные координаты точки";
//    String alreadyOccupied = "Уже занято, выберите другое поле";
//    String winnerName = "Победил игрок %s";
//    String noWinner = "Победила дружба";

    void showGreettings(String gameName);

    void showGameTypeMenu();

    void selectGameType(Gamer[] players);

    void showRules(Gamer[] gamers);

    void showField(Field field);

    Point getShootAuto(Gamer players, Field field);

    Point getShootManual(Gamer player, Field field);

    void showInvalidPoint();

    void showPointOccupied();

    void showWinner(Gamer[] players, Field field);

    void showGameOver();

}
