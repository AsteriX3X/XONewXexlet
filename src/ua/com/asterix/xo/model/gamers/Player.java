package ua.com.asterix.xo.model.gamers;

import ua.com.asterix.xo.model.Figure;
import ua.com.asterix.xo.model.Point;

public class Player extends Gamer {

    public Player(String name, Figure figure) {
        super(name, figure);
    }

    @Override
    public Point getShootRandom() {
        return Point.getRandomShootPoint();
    }

    @Override
    public Point getShoot(int x, int y) {
        return new Point(x, y);
    }

}
