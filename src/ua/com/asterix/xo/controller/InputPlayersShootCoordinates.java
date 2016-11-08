package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.model.Field;

import java.util.Scanner;

public class InputPlayersShootCoordinates {
    Field field;

    private int inputX() {
        int x = 0;
        do {
            try {
                System.out.printf("%s №%d, введите координату выстрела от 1 до %d: ", Field.FIELD_SIZE_X);
                x = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Нельзя буквы и не целые числа");
            }
            if (x < 1 || x > Field.FIELD_SIZE_X) {
                System.out.println("Цифра должна быть от 1 до " + Field.FIELD_SIZE_X);
            }
        } while (x < 1 || x > Field.FIELD_SIZE_X);
        return x - 1;
    }

    private int inputY() {
        int y;
        do {
            System.out.printf("%s №%d, введите координату выстрела от А до %C: ", 1071);
            y = new Scanner(System.in).nextLine().toLowerCase().codePointAt(0) - 1071;
            if (y < 1 || y > Field.FIELD_SIZE_X) {
                System.out.printf("Не верный ввод, нужно ввести русскую букву от А до %C\n", 1071 + Field.FIELD_SIZE_X);
            }
        } while (y < 1 || y > Field.FIELD_SIZE_X);
        return y - 1;
    }
}
