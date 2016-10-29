package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.exceptions.AlreadyOccupiedException;
import ua.com.asterix.xo.exceptions.InvalidPointException;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws AlreadyOccupiedException, InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
