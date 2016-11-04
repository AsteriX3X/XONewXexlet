package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Game;
import ua.com.asterix.xo.model.Player;

public class GameController {
        Field field;
        Player[] players = new Player[2];

    public Field getField() {
        return field;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void start() {
        players[0] = new Player("Denis", Figure.X);
        players[1] = new Player("Computer", Figure.O);
        Game game = new Game(players, field, "XOGame v0.1 beta");

    }
}
