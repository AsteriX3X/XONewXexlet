package ua.com.asterix.xo.controller;

import junit.framework.TestCase;
import org.junit.Test;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;

public class WinnerControllerTest {
    @Test
    public void getWinner() throws Exception {
        Field field = new Field();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(1, 2), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assert
    }

    @Test
    public void checkLine() throws Exception {

    }

    @Test
    public void checkRow() throws Exception {

    }

}