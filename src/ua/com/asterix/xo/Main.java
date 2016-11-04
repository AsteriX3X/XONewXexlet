package ua.com.asterix.xo;

import ua.com.asterix.xo.controller.GameController;
import ua.com.asterix.xo.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();

        ConsoleView consoleView = new ConsoleView();
        consoleView.showField(gameController);

    }
}
