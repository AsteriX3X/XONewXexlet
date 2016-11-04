package ua.com.asterix.xo.model;

import ua.com.asterix.xo.exceptions.InvalidPointException;

public class Field {
    private final static int FIELD_SIZE = 3;
    private final static int MIN_COORDINATE = 0;
    private final static int MAX_COORDINATE = FIELD_SIZE;
    private final Figure[][] fieldOfFigures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public static int getMaxCoordinate() {
        return MAX_COORDINATE;
    }

    public static int getMinCoordinate() {
        return MIN_COORDINATE;
    }

    public Figure[][] getFieldOfFigures() {
        return fieldOfFigures;
    }

//    public void initField() {
//        for (int x = 0; x < fieldOfFigures.length; x++) {
//            for (int y = 0; y < fieldOfFigures.length; y++) {
//                fieldOfFigures[x][y] = Figure.I;
//            }
//        }
//    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!isPointValid(point)) throw new InvalidPointException();
        return fieldOfFigures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!isPointValid(point)) throw new InvalidPointException();
        fieldOfFigures[point.getX()][point.getY()] = figure;
    }

    private boolean isPointValid(final Point point) {
        return isCoordinateValid(point.getX()) && isCoordinateValid(point.getY());
    }

    private boolean isCoordinateValid(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

}
