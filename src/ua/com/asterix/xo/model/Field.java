package ua.com.asterix.xo.model;

import ua.com.asterix.xo.exceptions.AlreadyOccupiedException;
import ua.com.asterix.xo.exceptions.InvalidPointException;

public class Field {

    private final static int FIELD_SIZE = 3;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = FIELD_SIZE;
    private Point point;
    private final Figure[][] figuresField = new Figure[FIELD_SIZE][FIELD_SIZE];

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return figuresField[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (figuresField[point.getX()][point.getY()] != null) {
            throw new AlreadyOccupiedException();
        }
        figuresField[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate(final int coordinate) {
        return MIN_COORDINATE <= coordinate && coordinate < MAX_COORDINATE;
    }

}
