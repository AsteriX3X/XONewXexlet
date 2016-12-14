package ua.com.asterix.xo.model;

import java.util.Random;

public class Field {
    public static final int FIELD_SIZE = 3;
    private final Figure[][] fieldOfFigures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public Field() {
    }

    public Figure[][] getFieldOfFigures() {
        return fieldOfFigures;
    }

    public Figure getFigure(final Point point) {
        return fieldOfFigures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) {
        fieldOfFigures[point.getX()][point.getY()] = figure;
    }

    public boolean isPointEmpty(final Point point) {
        return fieldOfFigures[point.getX()][point.getY()] == null;
    }

    public boolean isFieldFull() {
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++) {
                if (fieldOfFigures[x][y] == null)
                    return false;
            }
        }
        return true;
    }

    public static Point getRandomPoint() {
        return new Point(new Random().nextInt(Field.FIELD_SIZE), new Random().nextInt(Field.FIELD_SIZE));
    }

//    public static boolean isPointValid(final Point point) {
//        return isCoordinateValid(point.getX()) && isCoordinateValid(point.getY());
//    }
//
//    private static boolean isCoordinateValid(final int Coordinate) {
//        return Coordinate >= 0 && Coordinate < FIELD_SIZE;
//    }

}
