package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.gamers.Computer;
import ua.com.asterix.xo.model.gamers.Gamer;
import ua.com.asterix.xo.model.gamers.Player;
import ua.com.asterix.xo.view.ConsoleView;
import ua.com.asterix.xo.view.IView;
import ua.com.asterix.xo.view.WindowView;

public class GameController {
    private final Gamer[] players = new Gamer[2];
    private final Field field = new Field();
    private String gameName;
    public IView iView;
    public IView consoleView = new ConsoleView();
    public IView windowView = new WindowView();

    MoveController moveController = new MoveController();

    public void start() {
        players[0] = new Player("Denis", Figure.X);
        players[1] = new Computer("Computer", Figure.O);

        iView.showGameName();

        iView.showField();

//        moveController.applyFigure(field, players[0], Point.getRandomShootPoint());

    }
}
