package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.gamers.Gamer;

import java.util.Scanner;

public class InputPlayersShootCoordinates {

    public static int inputX(Gamer gamer) {
        int x;
        do {
            System.out.printf("%s, введите координату выстрела от А до %C: ", gamer.getName(), 1071 + Field.FIELD_SIZE);
            x = new Scanner(System.in).next().toLowerCase().codePointAt(0) - 1071;
            if (x < 1 || x > Field.FIELD_SIZE) {
                System.out.printf("Не верный ввод, нужно ввести русскую букву от А до %C\n", 1071 + Field.FIELD_SIZE);
            }
        } while (x < 1 || x > Field.FIELD_SIZE);
        return x - 1;
    }

    public static int inputY(Gamer gamer) {
        int y = 0;
        do {
            try {
                System.out.printf("%s, введите координату выстрела от 1 до %d: ", gamer.getName(), Field.FIELD_SIZE);
                y = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Нельзя вводить буквы и не целые числа");
            }
            if (y < 1 || y > Field.FIELD_SIZE) {
                System.out.println("Цифра должна быть от 1 до " + Field.FIELD_SIZE);
            }
        } while (y < 1 || y > Field.FIELD_SIZE);
        return y - 1;
    }

}
