package ua.com.asterix.xo.model.gamers;

import ua.com.asterix.xo.model.Figure;

public abstract class Gamer implements IShootable{
    private final String name;
    private final Figure figure;
//    public static Point shoot;

    public Gamer(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

//    @Override
//    public String toString() {
//        return name + ", символ = " + figure;
//    }

}
