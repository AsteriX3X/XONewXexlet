package ua.com.asterix.xo.trash;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.gamers.Player;

public class Game {

    private final Player[] players;
    private final Field field;
    private final String gameName;

    public Game(final Player[] players, final Field field, final String name) {
        this.players = players;
        this.field = field;
        this.gameName = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getGameName() {
        return gameName;
    }

}
