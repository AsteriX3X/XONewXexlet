package ua.com.asterix.xo.view;

import ua.com.asterix.xo.controller.GameController;
import ua.com.asterix.xo.model.Point;

public interface IView {

        Point startTurn();

        void showGameName();

        void showPlayers();

        void showField();

        void showWinner();

        void showDraw();

        void anotherGame();

        void showPointOccupied();

        GameController getGameController();

}
