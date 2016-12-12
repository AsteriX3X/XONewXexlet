package ua.com.asterix.xo.model;

public class Field {
    public static final int FIELD_SIZE = 3;
    private final Figure[][] fieldOfFigures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public Field() {
    }

    public Figure[][] getFieldOfFigures() {
        return fieldOfFigures;
    }

    public Figure getFigure(final Point point) {
        if (!isPointValid(point)) {
            System.out.println("Не верные координаты точки");   // TODO: 12.12.2016
        }
        return fieldOfFigures[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) {
        if (!isPointValid(point)) {
            System.out.println("Не верные координаты точки");   // TODO: 12.12.2016
        }
        if (!isPointOccupied(point)) {
            System.out.println("Эта ячейка уже занята, выберите другую");   // TODO: 12.12.2016
        }
        fieldOfFigures[point.getX()][point.getY()] = figure;
    }

    public boolean isFieldFull() {
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++) {
                if (fieldOfFigures[x][y] != null)
                    return false;
            }
        }
        return true;
    }

    private boolean isPointOccupied(final Point point) {
        return fieldOfFigures[point.getX()][point.getY()] != null;
    }

    private boolean isPointValid(final Point point) {
        return isCoordinateValid(point.getX()) && isCoordinateValid(point.getY());
    }

    private boolean isCoordinateValid(final int Coordinate) {
        return Coordinate >= 0 && Coordinate < FIELD_SIZE;
    }

}
