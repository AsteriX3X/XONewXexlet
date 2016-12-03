package ua.com.asterix.xo.model;

import junit.framework.TestCase;
import org.junit.Test;
import ua.com.asterix.xo.model.gamers.Player;

public class PlayerTest {
    @Test
    public void getName() throws Exception {
        final String inputValue = "Денис";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        TestCase.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() throws Exception {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = Figure.X;

        TestCase.assertEquals(expectedValue, actualValue);
    }

}