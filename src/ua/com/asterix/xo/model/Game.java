package ua.com.asterix.xo.model;

import ua.com.asterix.xo.controller.MoveController;
import ua.com.asterix.xo.model.gamers.Computer;
import ua.com.asterix.xo.model.gamers.Gamer;
import ua.com.asterix.xo.model.gamers.Player;
import ua.com.asterix.xo.view.ConsoleView;
import ua.com.asterix.xo.view.IView;
import ua.com.asterix.xo.view.WindowView;

public class Game {
    private final Gamer[] players = new Gamer[2];
    private final Field field = new Field();
    private String gameName;

    public Game() {
    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public IView iView;
    public ConsoleView consoleView = new ConsoleView();
    public IView windowView = new WindowView();

    MoveController moveController = new MoveController();

    public void start() {
        players[0] = new Player("Denis", Figure.X);
        players[1] = new Computer("Computer", Figure.O);

        consoleView.showGameName(gameName);

        iView.showField();

//        moveController.applyFigure(field, players[0], Point.getRandomShootPoint());

    }
}
