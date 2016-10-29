package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;

public class MoveController {

    private final Field field;
    private final Figure figure;
    private final Point point;

    public MoveController(Field field, Figure figure, Point point) {
        this.field = field;
        this.figure = figure;
        this.point = point;
    }

    public void applyFigure(final Field field, final Figure figure, final Point point) {

    }
}
