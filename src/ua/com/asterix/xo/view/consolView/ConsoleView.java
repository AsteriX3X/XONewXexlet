package ua.com.asterix.xo.view.consolView;

import ua.com.asterix.xo.model.Winner;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;
import ua.com.asterix.xo.model.gamers.Computer;
import ua.com.asterix.xo.model.gamers.Gamer;
import ua.com.asterix.xo.model.gamers.Player;
import ua.com.asterix.xo.view.IView;

import java.util.Scanner;

public class ConsoleView implements IView {
    private Point point;

    @Override
    public void showGreettings(String gameName) {
        String greeting = "Добро пожаловать в " + gameName;
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("~");
        }
    }

    @Override
    public void showGameTypeMenu() {
        System.out.println();
        System.out.println("1 - Компьютер против Компьютера");
        System.out.println("2 - Игрок против Компьютера");
        System.out.println("3 - Игрок против Игрока");
        System.out.println("==============================================");
        System.out.println("4 - Выход");
        System.out.print("Выберите тип игры (1, 2, 3) или 4 для выхода: ");
    }

    @Override
    public void selectGameType(Gamer[] players) {
        int gameType = 0;
        while (gameType < 1 || gameType > 4) {
            try {
                gameType = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вводить можно только целое число");
            }
            if (gameType < 1 || gameType > 4) {
                System.out.println("Нужно ввести цифру 1, 2, 3 или 4");
            }
        }
        initPlayers(players, gameType);
    }

    private void initPlayers(Gamer[] players, int gameType) {
        switch (gameType) {
            case 1:
                System.out.println("Режим - Компьютер против Компьютера");
                players[0] = new Computer("Компьютер 1", Figure.X);
                players[1] = new Computer("Компьютер 2", Figure.O);
                break;
            case 2:
                System.out.println("Режим - Игрок против Компьютера");
                players[0] = new Player("Игрок", Figure.X);
                players[1] = new Computer("Компьютер", Figure.O);
                break;
            case 3:
                System.out.println("Режим - Игрок против Игрока");
                players[0] = new Player("Игрок 1", Figure.X);
                players[1] = new Player("Игрок 2", Figure.O);
                break;
            case 4:
                System.out.println("Выход");
                break;
            default:
                System.out.println("Такого варианта нет. Что то пошло не так.");
                break;
        }
        if (gameType > 3) {
            System.exit(0);
        }
    }

    @Override
    public void showRules(Gamer[] players) {
        System.out.printf("%s играет символом %s, %s играет символом %s\n",
                players[0].getName(), players[0].getFigure(),
                players[1].getName(), players[1].getFigure());
    }

    @Override
    public void showField(Field field) {
        System.out.print(" ");
        for (char l = 'А'; l < 'А' + Field.FIELD_SIZE; l++) {
            System.out.print("  " + l);
        }
        System.out.println();
        for (int y = 0; y < Field.FIELD_SIZE; y++) {
            System.out.print(y + 1);
            for (int x = 0; x < Field.FIELD_SIZE; x++) {
                if (field.getFigure(new Point(x, y)) == null) {
                    System.out.print("  " + ".");
                } else {
                    System.out.print("  " + field.getFigure(new Point(x, y)));
                }
            }
            System.out.println();
        }
    }

    @Override
    public Point getShootAuto(Gamer player, Field field) {

        if (player.getName().equals("Компьютер") || player.getName().equals("Компьютер 1") || player.getName().equals("Компьютер 2")) {
            System.out.printf("Сделать ход за %s, символом %S", player.getName(), player.getFigure());
            new Scanner(System.in).nextLine();

            do {
                point = player.getShoot();
            }
            while (!field.isPointEmpty(point));

        } else {
            getShootManual(player, field);
        }
        return point;
    }

    @Override
    public Point getShootManual(Gamer player, Field field) {
        do {
            point = new Point(PlayersShootCoordinates.inputX(player), PlayersShootCoordinates.inputY(player));

            if (!field.isPointEmpty(point)) {
                showPointOccupied();
            }
        } while (!field.isPointEmpty(point));
        return point;
    }

    @Override
    public void showInvalidPoint() {

    }

    @Override
    public void showPointOccupied() {
        System.out.println("Уже занято, выберите другое поле");
    }

    @Override
    public void showWinner(Gamer[] players, Field field) {
        if (Winner.getWinnerFigure(field) == Figure.X) {
            System.out.printf("Победил %s", players[0].getName());
        } else {
            System.out.printf("Победил %s", players[1].getName());
        }
    }

    @Override
    public void showGameOver() {
        System.out.println("Ничья! Победила дружба!");
    }

//    private void printLine(int amount) {
//        for (int i = 0; i < amount * 6; i++) {
//            System.out.print("~");
//        }
//    }
//
//    private void showLine(Field field, int y) {
//        for (int x = 0; x < Field.FIELD_SIZE; x++) {
//            System.out.print(field.getFieldOfFigures()[x][y] + " ");
//            System.out.print(x < 2 ? "| " : "  ");
//        }
//    }

}
