package ua.com.asterix.xo.model;

import ua.com.asterix.xo.model.gamers.Gamer;
import ua.com.asterix.xo.view.IView;
import ua.com.asterix.xo.view.consolView.ConsoleView;

import javax.swing.*;

public class Game {
    private final Field field = new Field();
    private final Gamer[] players = new Gamer[2];
    private final String GAME_NAME = "XO Game v5.0";
    private IView consoleView = new ConsoleView();

    public void start() {
        consoleView.showGreettings(GAME_NAME);
        JOptionPane.showMessageDialog(null, "Начать игру?: ");
        consoleView.showGameTypeMenu();
        consoleView.selectGameType(players);
        startGameType(players);
    }

    private void startGameType(Gamer[] players) {
        while (true) {
            consoleView.showRules(players);
            if (isGamerShootWasFinal(players[0])) break;
            consoleView.showRules(players);
            if (isGamerShootWasFinal(players[1])) break;
        }
        consoleView.showField(field);
        if (field.isFieldFull() && !Winner.isWinner(field)) {
            consoleView.showGameOver();
        } else {
            consoleView.showWinner(players, field);
        }
    }

    private boolean isGamerShootWasFinal(Gamer player) {
        consoleView.showField(field);
        Point point = consoleView.getShootAuto(player, field);
        field.setFigure(point, player.getFigure());
        return field.isFieldFull() || Winner.isWinner(field);
    }

}
