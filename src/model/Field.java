package model;

public class Field {

    private final static int FIELD_SIZE = 3;
    private Point point;
    private Figure figure;
    private Field field;

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public void setFigure(Point point, Figure figure) {
        this.figure = figure;
    }


    public Figure getFigure(Point point) {
        return figure;
    }
}
