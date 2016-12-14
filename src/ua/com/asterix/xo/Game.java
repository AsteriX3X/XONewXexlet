package ua.com.asterix.xo;

import ua.com.asterix.xo.controller.InputPlayersShootCoordinates;
import ua.com.asterix.xo.controller.WinnerController;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;
import ua.com.asterix.xo.model.gamers.Computer;
import ua.com.asterix.xo.model.gamers.Gamer;
import ua.com.asterix.xo.model.gamers.Player;

import java.util.Scanner;

class Game {
    private final Gamer[] players = new Gamer[2];
    private final Field field = new Field();
    private final String GAME_NAME = "XO Game v5.0";
    private int gameType = 0;
    private Point point;

    void start() {
        String greeting = "Добро пожаловать в " + GAME_NAME;
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("~");
        }
        System.out.println();
        System.out.println("1 - Компьютер против Компьютера");
        System.out.println("2 - Игрок против Компьютера");
        System.out.println("3 - Игрок против Игрока");
        System.out.println("==============================");
        System.out.println("4 - Выход");
        System.out.print("Выберите тип игры (1, 2, 3) или 4 для выхода: ");


        while (gameType < 1 || gameType > 4) {
            try {
                gameType = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводить можно только целое число");
            }
            if (gameType < 1 || gameType > 4) {
                System.out.println("Нужно ввести цифру 1, 2 или 3");
            }
        }

        System.out.print("Выбан режим: - ");

        switch (gameType) {
            case 1:
                players[0] = new Computer("Компьютер 1", Figure.X);
                players[1] = new Computer("Компьютер 2", Figure.O);
                System.out.println("Компьютер против Компьютера");
                break;
            case 2:
                players[0] = new Player("Игрок", Figure.X);
                players[1] = new Computer("Компьютер", Figure.O);
                System.out.println("Игрок против Компьютера");
                break;
            case 3:
                players[0] = new Player("Игрок 1", Figure.X);
                players[1] = new Player("Игрок 2", Figure.O);
                System.out.println("Игрок против Игрока");
                break;
            case 4:
                System.out.println("Выход");
                break;
            default:
                System.out.println("Такого варианта нет. Что то пошло не так.");
                break;
        }
        if (gameType != 4) {
            startGameType(players[0], players[1]);
        }
    }

    private void startGameType(Gamer gamer1, Gamer gamer2) {
        while (true) {
            showRules(gamer1, gamer2);
            if (isGamerShootWasFinal(gamer1)) break;
            showRules(gamer1, gamer2);
            if (isGamerShootWasFinal(gamer2)) break;
        }
        Field.showField(field);

        if (field.isFieldFull() && !WinnerController.isWinner(field)) {
            System.out.println("Ничья! Победила дружба!");
        } else {
            if (WinnerController.getWinnerFigure(field) == Figure.X) {
                System.out.printf("Победил %s", gamer1.getName());
            } else {
                System.out.printf("Победил %s", gamer2.getName());
            }
        }
    }

    private void showRules(Gamer gamer1, Gamer gamer2) {
        System.out.printf("%s играет символом %s, %s играет символом %s\n",
                gamer1.getName(), gamer1.getFigure(), gamer2.getName(), gamer2.getFigure());
    }

    private boolean isGamerShootWasFinal(Gamer gamer) {
        Field.showField(field);
        if (gamer.getName().equals("Компьютер") || gamer.getName().equals("Компьютер 1") || gamer.getName().equals("Компьютер 2")) {
            System.out.printf("Сделать ход за %s, символом %S", gamer.getName(), gamer.getFigure());
            new Scanner(System.in).nextLine();

            do {
                point = gamer.getShoot();
            }
            while (!field.isPointEmpty(point));

            field.setFigure(point, gamer.getFigure());
        } else {

            do {
                point = new Point(InputPlayersShootCoordinates.inputX(gamer), InputPlayersShootCoordinates.inputY(gamer));

                if (!field.isPointEmpty(point)){
                    System.out.println("Уже занято, выберите другое поле");
                }
            } while (!field.isPointEmpty(point));

            field.setFigure(point, gamer.getFigure());
        }
        return field.isFieldFull() || WinnerController.isWinner(field);
    }

}
