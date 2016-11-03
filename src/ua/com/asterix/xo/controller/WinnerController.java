package ua.com.asterix.xo.controller;

import ua.com.asterix.xo.exceptions.InvalidPointException;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;

public class WinnerController {

    public Figure getWinner(Field field) throws InvalidPointException {
        for (int i = 0; i < Field.getMaxCoordinate(); i++) {
            if (checkLine(field, i)) {
                return field.getFigure(new Point(i, 0));
            }
            if (checkRow(field, i)) {
                return field.getFigure(new Point(0, i));
            }
        }

        if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1)) &&
                field.getFigure(new Point(0, 0)) == field.getFigure(new Point(2, 2))) {
            return field.getFigure(new Point(0, 0));
        }

        if (field.getFigure(new Point(0, 2)) == field.getFigure(new Point(1, 1)) &&
                field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 0))) {
            return field.getFigure(new Point(1, 1));
        }

        return null;
    }

    boolean checkLine(Field field, int lineNumber) {
        try {
            if (field.getFigure(new Point(0, lineNumber)) == null) {
                return false;
            }
            return (field.getFigure(new Point(lineNumber, 0)) == field.getFigure(new Point(lineNumber, 1)) &&
                    field.getFigure(new Point(lineNumber, 0)) == field.getFigure(new Point(lineNumber, 2)));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    boolean checkRow(Field field, int rowNumber) {
        try {
            if (field.getFigure(new Point(0, rowNumber)) == null) {
                return false;
            }
            return (field.getFigure(new Point(0, rowNumber)) == field.getFigure(new Point(1, rowNumber)) &&
                    field.getFigure(new Point(0, rowNumber)) == field.getFigure(new Point(2, rowNumber)));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

}
