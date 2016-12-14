package ua.com.asterix.xo.model;

public class Winner {

    public static Figure getWinnerFigure(Field field) {
        int count = 0;

        for (int x = 0; x < Field.FIELD_SIZE; x++) {
            for (int y = 0; y < Field.FIELD_SIZE; y++) {
                if (field.getFigure(new Point(x, y)) != null) {
                    count++;
                }
            }
        }
        if (count % 2 == 0) {
            return Figure.O;
        } else
            return Figure.X;
    }

    public static boolean isWinner(Field field) {
        for (int i = 0; i < Field.FIELD_SIZE; i++) {
            if (isLineWin(field, i) || isRowWin(field, i)){
                return true;
            }
        }
        return isCrossWin(field);
    }

    private static boolean isCrossWin(Field field) {
        return field.getFigure(new Point(0, 0)) != null &&
               field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1)) &&
               field.getFigure(new Point(0, 0)) == field.getFigure(new Point(2, 2)) ||
               field.getFigure(new Point(1, 1)) != null &&
               field.getFigure(new Point(1, 1)) == field.getFigure(new Point(0, 2)) &&
               field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 0));
    }

    private static boolean isLineWin(Field field, int lineNumber) {
        return field.getFigure(new Point(lineNumber, 0)) != null &&
               field.getFigure(new Point(lineNumber, 0)) == field.getFigure(new Point(lineNumber, 1)) &&
               field.getFigure(new Point(lineNumber, 0)) == field.getFigure(new Point(lineNumber, 2));
    }

    private static boolean isRowWin(Field field, int rowNumber) {
        return field.getFigure(new Point(0, rowNumber)) != null &&
               field.getFigure(new Point(0, rowNumber)) == field.getFigure(new Point(1, rowNumber)) &&
               field.getFigure(new Point(0, rowNumber)) == field.getFigure(new Point(2, rowNumber));
    }

}
