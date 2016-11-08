package ua.com.asterix.xo.model;

public class Field {
    public static final int FIELD_SIZE_X = 3;
    public static final int FIELD_SIZE_Y = 3;
    public static final int MIN_COORDINATE = 0;
    private final Figure[][] fieldOfFigures = new Figure[FIELD_SIZE_X][FIELD_SIZE_Y];

    public Field() {
    }

    public Figure[][] getFieldOfFigures() {
        return fieldOfFigures;
    }

    public Figure getFigure(final Point point) {
        // TODO: 08.11.2016
//        if (!isPointValid(point));
        return fieldOfFigures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) {
//        if (!isPointValid(point));
        // TODO: 08.11.2016
        fieldOfFigures[point.getX()][point.getY()] = figure;
    }

    public boolean isFieldFull() {
        for (int x = 0; x < FIELD_SIZE_X; x++) {
            for (int y = 0; y < FIELD_SIZE_Y; y++) {
                if (fieldOfFigures[x][y] != null)
                    return false;
            }
        }
        return true;
    }

    private boolean isPointValid(final Point point) {
        return isXCoordinateValid(point.getX()) && isYCoordinateValid(point.getY());
    }

    private boolean isXCoordinateValid(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < FIELD_SIZE_X;
    }

    private boolean isYCoordinateValid(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < FIELD_SIZE_Y;
    }

}
