package ua.com.asterix.xo.model;

import java.util.Random;

public class Point {
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Point getRandomShootPoint() {
        return new Point(new Random().nextInt(Field.FIELD_SIZE), new Random().nextInt(Field.FIELD_SIZE));
    }

}
