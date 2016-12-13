package ua.com.asterix.xo;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;
import ua.com.asterix.xo.model.gamers.Computer;
import ua.com.asterix.xo.model.gamers.Gamer;
import ua.com.asterix.xo.model.gamers.Player;

import java.util.Scanner;

public class Game {
    private final Gamer[] players = new Gamer[2];
    private final Field field = new Field();
    private final String GAME_NAME = "XO Game v5.0";
    private int gameType = 0;

    public void start() {
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
        showField(field);

        if (field.isFieldFull()) {
            System.out.println("Победила дружба!");
        } else {
            System.out.println("Победил %s");
        }

    }

    private void showRules(Gamer gamer1, Gamer gamer2) {
        System.out.printf("%s играет символом %s, %s играет символом %s\n",
                gamer1.getName(), gamer1.getFigure(), gamer2.getName(), gamer2.getFigure());
    }

    private boolean isGamerShootWasFinal(Gamer gamer) {
        showField(field);
        if (gamer.getName().equals("Компьютер") || gamer.getName().equals("Компьютер 1") || gamer.getName().equals("Компьютер 2")) {
            System.out.printf("Сделать ход за %s, символом %S", gamer.getName(), gamer.getFigure());
            new Scanner(System.in).nextLine();

            Point point;
            do {
                point = gamer.getShoot();
            }
            while (!field.isPointEmpty(point));

            field.setFigure(point, gamer.getFigure());
        } else {
            int x = inputX(gamer);
            int y = inputY(gamer);
            field.setFigure(new Point(x, y), gamer.getFigure());
        }

        return field.isFieldFull() || isWinner(field);
    }

    private int inputY(Gamer gamer) {
        int x = 0;
        do {
            try {
                System.out.printf("%s, введите координату выстрела от 1 до %d: ", gamer.getName(), Field.FIELD_SIZE);
                x = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Нельзя вводить буквы и не целые числа");
            }
            if (x < 1 || x > Field.FIELD_SIZE) {
                System.out.println("Цифра должна быть от 1 до " + Field.FIELD_SIZE);
            }
        } while (x < 1 || x > Field.FIELD_SIZE);
        return x - 1;
    }

    private int inputX(Gamer gamer) {
        int y;
        do {
            System.out.printf("%s, введите координату выстрела от А до %C: ", gamer.getName(), 1071 + Field.FIELD_SIZE);
            y = new Scanner(System.in).nextLine().toLowerCase().codePointAt(0) - 1071;
            if (y < 1 || y > Field.FIELD_SIZE) {
                System.out.printf("Не верный ввод, нужно ввести русскую букву от А до %C\n", 1071 + Field.FIELD_SIZE);
            }
        } while (y < 1 || y > Field.FIELD_SIZE);
        return y - 1;
    }

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

    public boolean isWinner(Field field) {
        for (int i = 0; i < Field.FIELD_SIZE; i++) {
            if (isLineWin(field, i)) {
                return true;
            }
            if (isRowWin(field, i)) {
                return true;
            }
        }

        if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1)) &&
                field.getFigure(new Point(0, 0)) == field.getFigure(new Point(2, 2)) &&
                field.getFigure(new Point(0, 0)) != null) {
            return true;
        }

        if (field.getFigure(new Point(0, 2)) == field.getFigure(new Point(1, 1)) &&
                field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 0)) &&
                field.getFigure(new Point(1, 1)) != null) {
            return true;
        }

        return false;
    }

    private boolean isLineWin(Field field, int lineNumber) {
        if (field.getFigure(new Point(lineNumber, 0)) == null) {
            return false;
        }
        return (field.getFigure(new Point(lineNumber, 0)) == field.getFigure(new Point(lineNumber, 1)) &&
                field.getFigure(new Point(lineNumber, 0)) == field.getFigure(new Point(lineNumber, 2)));
    }

    private boolean isRowWin(Field field, int rowNumber) {
        if (field.getFigure(new Point(0, rowNumber)) == null) {
            return false;
        }
        return (field.getFigure(new Point(0, rowNumber)) == field.getFigure(new Point(1, rowNumber)) &&
                field.getFigure(new Point(0, rowNumber)) == field.getFigure(new Point(2, rowNumber)));
    }

}
