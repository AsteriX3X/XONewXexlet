package ua.com.asterix.xo.model.gamers;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;

public class Computer extends Gamer {

    public Computer(String name, Figure figure) {
        super(name, figure);
    }

    @Override
    public Point getShoot() {
        return Field.getRandomPoint();
    }

}
